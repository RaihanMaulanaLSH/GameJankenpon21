package com.example.gamejankenpon

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    private lateinit var computerImageView : ImageView
    private lateinit var therockImageButton: ImageButton
    private lateinit var guntingImageButton: ImageButton
    private lateinit var paperImageButton: ImageButton
    private lateinit var resultImageView : ImageView

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        therockImageButton = findViewById(R.id.therockImageButton)
        guntingImageButton = findViewById(R.id.guntingImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        resultImageView = findViewById(R.id.resultImageView)

    }

    private fun initListiners() {
        therockImageButton.setOnClickListener { startGame("ROCK")}
        guntingImageButton.setOnClickListener { startGame("SCISSORS")}
        paperImageButton.setOnClickListener { startGame("PAPER")}
    }

    private fun startGame(option:String) {
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when {
            Game.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.tryagainn)
            Game.isWin(option, computerOption) -> resultImageView.setImageResource(R.drawable.winner)
            else -> resultImageView.setImageResource(R.drawable.draw)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListiners()
    }


}