package com.example.zoo.Activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zoo.Adapters.ExhibitAdapter
import com.example.zoo.AppCore.Model.Exhibit
import com.example.zoo.AppCore.Model.Plant
import com.example.zoo.Presenters.ExhibitPresenter
import com.example.zoo.R
import com.example.zoo.Views.ExhibitView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_area.*
import kotlinx.android.synthetic.main.activity_main.*

class ExhibitActivity : ActivityBase(), ExhibitView {
    private lateinit var exhibitPresenter: ExhibitPresenter
    private lateinit var exhibitAdapter: ExhibitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area)

        exhibitPresenter = ExhibitPresenter(this)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onLoadFinished(plants: List<Plant>) {
        TODO("Not yet implemented")
    }

    override fun onLoadError(error: String) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun initView() {
        super.initView()

        var intent = getIntent().getStringExtra("exhibit")
        var exhibit = Gson().fromJson(intent, Exhibit::class.java)
        setTitle(exhibit.name)

        Picasso.get().load(exhibit.img).centerCrop().fit().into(exhibit_img)
        exhibit_summary.text = exhibit.info
        work_period.text = exhibit.memo
        area_type.text = exhibit.category
        link.text = "在網頁開啟"
        link.setOnClickListener(){
            var browser = Intent(Intent.ACTION_VIEW, Uri.parse(exhibit.url))
            startActivity(browser)
        }


        exhibitAdapter =  ExhibitAdapter()
        exhibitAdapter.setClickListener(object: ExhibitAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                var intent = Intent(this@ExhibitActivity, DetailActivity::class.java)
                intent.putExtra("plant", Gson().toJson(exhibitPresenter.plants[position]))
                startActivity(intent)
            }
        })

        exhibit_detail_list.layoutManager = LinearLayoutManager(this)
        exhibit_detail_list.adapter = exhibitAdapter

    }
}
