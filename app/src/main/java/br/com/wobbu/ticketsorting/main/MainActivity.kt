package br.com.wobbu.ticketsorting.main

import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import br.com.wobbu.ticketsorting.R
import br.com.wobbu.ticketsorting.model.Ticket

class MainActivity : AppCompatActivity(), MainView {

    lateinit var presenter: MainPresenter
    lateinit var tickets: ArrayList<Ticket>
    lateinit var recyclerView: RecyclerView
    lateinit var viewAnimation: RelativeLayout
    lateinit var loading: ImageView
    lateinit var btSort: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_ticket)
        viewAnimation = findViewById(R.id.view_animation)
        loading = findViewById(R.id.loading)
        btSort = findViewById(R.id.bt_sort)

        presenter = MainPresenter(this)
        tickets = presenter.populateTicket()

        populateRecyclerView(tickets)

        btSort.setOnClickListener(sortClick)
    }

    override fun populateRecyclerView(list: ArrayList<Ticket>) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        var adapter = MainAdapter(list)
        recyclerView.adapter = adapter

        // just to show result in Logcat
        list.forEach {
            Log.i("TICKET_SORTED_ARRAY", "${it.origin} to ${it.destination}")
        }
    }

    var sortClick = View.OnClickListener {
        presenter.sortTicket(tickets)
        viewAnimation.visibility = View.VISIBLE
        var animation = loading.drawable as AnimationDrawable
        animation.start()

        Handler().postDelayed({
            viewAnimation.visibility = View.GONE
            btSort.visibility = View.GONE
        }, 3200)
    }
}
