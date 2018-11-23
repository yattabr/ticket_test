package br.com.wobbu.ticketsorting.main

import android.util.Log
import br.com.wobbu.ticketsorting.model.Ticket
import kotlin.collections.ArrayList

class MainPresenter(var mainView: MainView) {

    fun sortTicket(tickets: ArrayList<Ticket>): ArrayList<Ticket> {

        var sortedTickets = ArrayList<Ticket>()

        // Make a loop to get origin and compare with a destination
        // if have one destination same as origin, add this ticket
        // in the final will be only one object who dont have same origin and destination
        // this object is the final destination.
        for (ticket in tickets) {
            for (item in tickets) {
                if (item.destination == ticket.origin) {
                    sortedTickets.add(item)
                }
            }
        }

        // I created one Extention to compare the lists and get the only object who is not in the sortedTickets list
        // this object is the final destination
        tickets.compareIfHaveAllObjects(sortedTickets)


        // Reverse the list to show the Start Origin to Final Destination
        sortedTickets.reverse()

        // call the MainActivity to populate the recyclerView
        mainView.populateRecyclerView(sortedTickets)

        return sortedTickets
    }

    /*
    Right travel:
    - Barcelona to Madrid
    - Madrid to Portugal
    - Portugal to London
    - London to New York
     */
    fun populateTicket(): ArrayList<Ticket> {
        var arrayTicket = ArrayList<Ticket>()
        var ticket = Ticket()
        ticket.origin = "London"
        ticket.destination = "New York"
        ticket.transport = "Airplane"
        ticket.numTicket = "78A"
        ticket.seat = "25F"
        ticket.baggage = "Baggage will we automatically transferred from your last leg"
        arrayTicket.add(ticket)

        ticket = Ticket()
        ticket.origin = "Barcelona"
        ticket.destination = "Madrid"
        ticket.transport = "Train"
        ticket.numTicket = "MH24R"
        ticket.seat = "4D"
        ticket.baggage = "Baggage drop at ticket counter 344"
        arrayTicket.add(ticket)

        ticket = Ticket()
        ticket.origin = "Portugal"
        ticket.destination = "London"
        ticket.transport = "Bus"
        ticket.numTicket = "223"
        ticket.seat = "30"
        ticket.baggage = "Baggage have the ticket 223"
        arrayTicket.add(ticket)

        ticket = Ticket()
        ticket.origin = "Madrid"
        ticket.destination = "Portugal"
        ticket.transport = "Airplane"
        ticket.seat = "06D"
        ticket.numTicket = "R12"
        ticket.baggage = "Baggage already dispatched"
        arrayTicket.add(ticket)

        return arrayTicket
    }

    private infix fun <T> Collection<T>.compareIfHaveAllObjects(collection: ArrayList<T>?) =
        collection?.let {
            for (i in this) {
                if (!it.contains(i)) {
                    it.add(0, i)
                }
            }
        }
}