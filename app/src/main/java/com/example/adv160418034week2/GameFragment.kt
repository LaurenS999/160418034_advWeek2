package com.example.adv160418034week2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import java.util.*

class GameFragment : Fragment() {

    var number1 = 0;
    var number2 = 0;
    var jawabanBenar = 0;
    var jawabanPlayer =0;
    var poin = 0;
    public fun generateNumber() {
        val r = Random()
        number1 = r.nextInt(51)
        number2 = r.nextInt(51)

        txtNumber1.text = number1.toString()
        txtNumber2.text = number2.toString()

        jawabanBenar = number1 + number2
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        generateNumber()
        if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).PlayerName
            txtTurn.text = "$playerName's Turn"
        }

        btnSubmit.setOnClickListener{
            jawabanPlayer = Integer.parseInt(txtJawaban.text.toString())
            if(jawabanBenar == jawabanPlayer)
            {
                poin++
                generateNumber()
            }
            else
            {
                val action = GameFragmentDirections.actionResultFragment(poin);
                Navigation.findNavController(it).navigate(action)
            }
        }

    }
}