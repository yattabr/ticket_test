package br.com.wobbu.ticketsorting

import br.com.wobbu.ticketsorting.main.MainPresenter
import br.com.wobbu.ticketsorting.main.MainView
import br.com.wobbu.ticketsorting.model.Ticket
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import kotlin.collections.ArrayList

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun verifyIfSortIsAdjutingArray() {

        var mainView = Mockito.mock(MainView::class.java)
        var presenter = MainPresenter(mainView)


        // The Wrong order Array
        var messArrayTicket = presenter.populateTicket()


        // Correct order Array
        var expectedArrayTicket = ArrayList<Ticket>()
        var ticket = Ticket()
        ticket.origin = "Barcelona"
        ticket.destination = "Madrid"
        ticket.transport = "Train"
        ticket.numTicket = "MH24R"
        ticket.baggage = "Baggage drop at ticket counter 344"
        expectedArrayTicket.add(ticket)

        ticket = Ticket()
        ticket.origin = "Madrid"
        ticket.destination = "Portugal"
        ticket.transport = "Airplane"
        ticket.numTicket = "R12"
        ticket.baggage = "Baggage already dispatched"
        expectedArrayTicket.add(ticket)

        ticket = Ticket()
        ticket.origin = "Portugal"
        ticket.destination = "London"
        ticket.transport = "Bus"
        ticket.numTicket = "223"
        ticket.baggage = "Baggage have the ticket 223"
        expectedArrayTicket.add(ticket)

        ticket = Ticket()
        ticket.origin = "London"
        ticket.destination = "New York"
        ticket.transport = "Airplane"
        ticket.numTicket = "78A"
        ticket.baggage = "Baggage will we automatically transferred from your last leg"
        expectedArrayTicket.add(ticket)

        var sortedArrayTicket = presenter.sortTicket(messArrayTicket)

//        Assert.assertEquals(expectedArrayTicket, sortedArrayTicket)
//        Assert.assertNotEquals(messArrayTicket, sortedArrayTicket)

    }
}
