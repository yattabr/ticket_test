package br.com.wobbu.ticketsorting.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.wobbu.ticketsorting.R
import br.com.wobbu.ticketsorting.model.Ticket


class MainAdapter(var origList: ArrayList<Ticket>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_ticket, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = origList[position]
        holder as MyViewHolder
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return origList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTicketNum = itemView.findViewById(R.id.txt_num_ticket) as TextView
        var txtTravel = itemView.findViewById(R.id.txt_travel) as TextView
        var txtTBaggage = itemView.findViewById(R.id.txt_baggage) as TextView
        var imgTransport = itemView.findViewById(R.id.img_tranport) as ImageView
        lateinit var item: Ticket

        fun bind(currentItem: Ticket) {
            item = currentItem

            txtTicketNum.text = item.numTicket
            txtTravel.text = "Fly from ${item.origin} to ${item.destination}"
            txtTBaggage.text = item.baggage

            when (item.transport) {
                "Airplane" ->
                    imgTransport.setImageResource(R.drawable.plane)

                "Train" ->
                    imgTransport.setImageResource(R.drawable.train)

                "Bus" ->
                    imgTransport.setImageResource(R.drawable.bus)
            }
        }
    }
}