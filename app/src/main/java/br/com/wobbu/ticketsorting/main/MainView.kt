package br.com.wobbu.ticketsorting.main

import br.com.wobbu.ticketsorting.model.Ticket

interface MainView {

    fun populateRecyclerView(list: ArrayList<Ticket>)

}