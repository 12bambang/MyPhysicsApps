package com.example.myphysicsapps.quiz

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.myphysicsapps.R
import com.example.myphysicsapps.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityQuizBinding
    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount = 1
    private val QUIZ_COUNT = 5

    private val quizData = mutableListOf(
        mutableListOf("Satuan kuat arus listrik dalam SI adalah", "Ampere","Volt","Coulomb","Ohm"),
        mutableListOf("Pesawat sederhana yang digunakan saat mengerek bendera ketika upacara setiap hari Senin adalah","Katrol","Pengungkit","Roda berporos","Bidang miring"),
        mutableListOf("Sebuah besi didekatkan dengan sebuah magnet sehingga besi tersebut menjadi magnet dan mampu menarik serbuk besi yang ada di dekatnya, Hal tersebut adalah pembuatan magnet dengan cara", "Induksi","Elektromagnetik", "Gosokan", "Arus listrik"),
        mutableListOf("Waktu yang diperlukan oleh bumi untuk berputar pada porosnya dinamakan","Rotasi","Revolusi", "Kala rotasi", "Kala revolusi"),
        mutableListOf("Berikut yang termasuk teladan dari energi listrik diubah menjadi energi gerak yakni","kipas angin","lampu","TV","setrika"),
        mutableListOf("Permainan trampolin memanfaatkan gaya","Pegas","Gesek","Gravitasi","Panas"),
        mutableListOf("Dua muatan titik yang sejenis dan sama besar qA = qB =10^ -2 C pada jarak 10 cm satu dari yang lain. Gaya tolak yang dialami kedua muatan itu (dalam Newton) adalah","9.10^ 7", "9.10^ -14", "9.10^ -9","9.10^ -5"),
        mutableListOf("Rudi mengamati benda yang memiliki sifat-sifat berikut : (1) susunan molekul tidak teratur (2) letak molekul berdekatan (3) dapat berpindah tempat. berdasarkan sifat sifat zat yang di sebutkan benda yang diamati rudi adalah","Air","Asap","Pensil","Penggaris"),
        mutableListOf("Faktor-faktor yang mempengaruhi besarnya tekanan adalah","luas bidang tekan dan gaya tekan","gaya tekan dan massa benda","gaya tekan dan gaya gravitasi","luas bidang tekan dan gaya gravitasi"),
        mutableListOf("Perpindahan energi oleh pancaran sinar matahari dinamakan","Radiasi", "Konduksi", "Isolasi", "Konveksi"),
        mutableListOf("Semua benda yang dapat memancarkan cahaya disebut","Sumber cahaya","Cahaya lampu","Cahaya terang","Benda bercahaya"),
        mutableListOf("Kaca spion kendaraan adalah salah satu pemanfaatan cermin","Cembung", "Cekung","Datar", "Silinder")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_quiz)

        binding = ActivityQuizBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // shuffle quiz
        quizData.shuffle()

        showNextQuiz()
    }

    fun showNextQuiz(){
        //update
        binding.itungQuiz.text = getString(R.string.itungquiz,quizCount)

        //pilih 1 quiz set
        val quiz = quizData[0]

        //set pertanyaan sama jawaban yang bener
        binding.question.text = quiz[0]
        rightAnswer = quiz[1]

        //hapus pertanyaan dari quiz
        quiz.removeAt(0)

        //shuffle jawaban sama pilihan
        quiz.shuffle()

        //set pilihan
        binding.btnPilih1.text = quiz[0]
        binding.btnPilih2.text = quiz[1]
        binding.btnPilih3.text = quiz[2]
        binding.btnPilih4.text = quiz[3]

        //hapus ini quiz dari quizData
        quizData.removeAt(0)

    }
    fun checkAnswer(view: View){
        val tombolJawaban: Button = findViewById(view.id)
        val tombolText = tombolJawaban.text.toString()

        val alertJudul: String
        if(tombolText == rightAnswer){
            //bener
            alertJudul = "Yeayyy Kamu Benarr :)"
            rightAnswerCount++
        } else {
            //salah
            alertJudul = "Yahhhhh Kamu Salah :("
        }

        //dialog
        AlertDialog.Builder(this)
            .setTitle(alertJudul)
            .setMessage("jawabannya adalah $rightAnswer")
            .setPositiveButton("OK") {dialogInterface, i ->
                checkQuizCount()
            }
            .setCancelable(false)
            .show()

    }
    fun checkQuizCount(){
        if (quizCount == QUIZ_COUNT){
            //nampilin hasil
            val intent = Intent(this@QuizActivity, hasilQuizActivity::class.java)
            intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
            startActivity(intent)

        } else {
            quizCount++
            showNextQuiz()
        }
    }
}