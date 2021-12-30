package com.example.zoo.Activities

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.zoo.Views.ViewBase

open class ActivityBase: AppCompatActivity(), ViewBase {
    private lateinit var loadingDialog: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun showLoading() {
        loadingDialog.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loadingDialog.visibility = View.GONE
    }

    override fun initView() {
        loadingDialog = ProgressBar(this)
    }
}