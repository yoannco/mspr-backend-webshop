package com.epsi.msprbackendwebshop

import com.epsi.msprbackendwebshop.models.Customer
import com.epsi.msprbackendwebshop.models.Line
import com.epsi.msprbackendwebshop.models.Order
import com.epsi.msprbackendwebshop.repository.CustomerApiClient
import com.epsi.msprbackendwebshop.services.CustomerService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private lateinit var customerService: CustomerService

    @MockBean
    private lateinit var customerApiClient: CustomerApiClient

    @Test
    fun `getCustomerByEmail should return customer`() {
        // Given
        val token = "your_token"
        val email = "customer@example.com"
        val expectedCustomer = Customer(
                id = 1,
                name = "John Doe",
                countryCode = "US",
                codeClient = "12345",
                email = email
        )

        `when`(customerApiClient.getCustomerByEmail(token, email)).thenReturn(Mono.just(expectedCustomer))

        // When
        val result = customerService.getCustomerByEmail(token, email)

        // Then
        StepVerifier.create(result)
                .expectNext(expectedCustomer)
                .verifyComplete()
    }

    @Test
    fun `getCustomers should return list of customers`() {
        // Given
        val token = "your_token"
        val expectedCustomers = listOf(
                Customer(1, "John Doe", "US", "12345", "john@example.com"),
                Customer(2, "Jane Smith", "UK", "67890", "jane@example.com")
        )

        `when`(customerApiClient.getCustomers(token)).thenReturn(Flux.fromIterable(expectedCustomers))

        // When
        val result = customerService.getCustomers(token)

        // Then
        StepVerifier.create(result)
                .expectNextSequence(expectedCustomers)
                .verifyComplete()
    }

    @Test
    fun `getOrders should return list of orders for a customer`() {
        // Given
        val token = "your_token"
        val email = "customer@example.com"
        val customer = Customer(1, "John Doe", "US", "12345", email)
        val expectedOrders = listOf(
                Order(
                        socid = "socid",
                        statut = "statut",
                        billed = "billed",
                        lines = listOf(Line("fk_commande", "commande_id", "ref", "libelle")),
                        ref = "order1"
                ),
                Order(
                        socid = "socid2",
                        statut = "statut2",
                        billed = "billed2",
                        lines = listOf(Line("fk_commande2", "commande_id2", "ref2", "libelle2")),
                        ref = "order2"
                )
        )

        `when`(customerApiClient.getCustomerByEmail(token, email)).thenReturn(Mono.just(customer))
        `when`(customerApiClient.getOrders(token, customer.codeClient)).thenReturn(Flux.fromIterable(expectedOrders))

        // When
        val result = customerService.getOrders(token, email)

        // Then
        StepVerifier.create(result)
                .expectNextSequence(expectedOrders)
                .verifyComplete()
    }
}
