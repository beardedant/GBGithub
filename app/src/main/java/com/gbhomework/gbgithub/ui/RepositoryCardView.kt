package com.gbhomework.gbgithub.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView

class RepositoryCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    val nameView: TextView = TextView(context)
    val languageView: TextView = TextView(context)
    val lastUpdateView: TextView = TextView(context)

    init {
        addView(nameView)
        addView(languageView)
        addView(lastUpdateView)
    }
}