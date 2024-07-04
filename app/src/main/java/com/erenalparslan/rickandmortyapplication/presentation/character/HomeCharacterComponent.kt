package com.erenalparslan.rickandmortyapplication.presentation.character

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.erenalparslan.rickandmortyapplication.R
import com.erenalparslan.rickandmortyapplication.common.downloadFromUrl
import com.erenalparslan.rickandmortyapplication.databinding.ComponentHomeCharacterBinding
import com.erenalparslan.rickandmortyapplication.rickandmorty.ui.home.HomeCharacterUiData

class HomeCharacterComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attributeSet, defStyleAttr) {

    private val _binding =
        ComponentHomeCharacterBinding.inflate(LayoutInflater.from(context), this, false)

    init {
        addView(_binding.root)
    }

    fun characterItemClickListener(characterClick: (view: View) -> Unit) {
        _binding.root.setOnClickListener {
            characterClick.invoke(it)
        }
    }

    fun setCharacterData(homeCharacterUiData: HomeCharacterUiData) {
        _binding.apply {
            characterGender.text = homeCharacterUiData.gender
            characterImage.downloadFromUrl(homeCharacterUiData.image)
            characterName.text = homeCharacterUiData.name
            when (homeCharacterUiData.gender) {
                GENDER_TYPE_UNKNOWN -> {
                    characterGenderImage.setImageResource(R.drawable.ic_baseline_unknown_48)
                }
                GENDER_TYPE_MALE -> {
                    characterGenderImage.setImageResource(R.drawable.ic_baseline_male_48)
                }
                GENDER_TYPE_FEMALE -> {
                    characterGenderImage.setImageResource(R.drawable.ic_baseline_female_48)
                }
            }
        }
    }

    companion object {
        private const val GENDER_TYPE_FEMALE = "Female"
        private const val GENDER_TYPE_MALE = "Male"
        private const val GENDER_TYPE_UNKNOWN = "unknown"
    }
}