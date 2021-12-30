package com.example.zoo.Activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zoo.Adapters.MainAdapter
import com.example.zoo.AppCore.Model.Exhibit
import com.example.zoo.Presenters.MainPresenter
import com.example.zoo.R
import com.example.zoo.Views.MainView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ActivityBase(), MainView{

    private lateinit var mainPresenter:MainPresenter
    private lateinit var mainAdapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainPresenter = MainPresenter(this)
    }

    override fun initView(){
        super.initView()
        setContentView(R.layout.activity_main)

        mainAdapter =  MainAdapter()
        mainAdapter.setClickListener(object: MainAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                var intent = Intent(this@MainActivity, ExhibitActivity::class.java)
                intent.putExtra("exhibit", Gson().toJson(mainPresenter.exhibitList[position]))
                startActivity(intent)
            }
        })

        exhibit_list.layoutManager = LinearLayoutManager(this)
        exhibit_list.adapter = mainAdapter
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        mainPresenter?.loadData()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onLoadFinished(data: List<Exhibit>) {
        runOnUiThread(){
            mainAdapter.setData(data)
            mainAdapter.notifyDataSetChanged()
        }

    }

    override fun onLoadError(error:String) {
        runOnUiThread(){
            AlertDialog.Builder(this)
                .setMessage(error)
                .setPositiveButton("OK", null)
                .show()
        }
    }

}