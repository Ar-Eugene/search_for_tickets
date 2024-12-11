package com.example.searchfortickets.airTickets.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.searchfortickets.airTickets.domain.models.Offer
import com.example.searchfortickets.airTickets.ui.view_model.AirTicketsViewModel
import com.example.searchfortickets.databinding.FragmentAirTicketsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel



class AirTicketsFragment : Fragment() {
    private lateinit var binding: FragmentAirTicketsBinding
    private lateinit var offerFeedAdapter: OfferFeedAdapter
    private val airTicketsViewModel: AirTicketsViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAirTicketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Создаем адаптер для RecyclerView
        offerFeedAdapter = OfferFeedAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = offerFeedAdapter
        }
        // Вызываем getOfferFeed и наблюдаем за offerFeed LiveData
        airTicketsViewModel.getOfferFeed("someSearchTerm")
        airTicketsViewModel.offerFeed.observe(viewLifecycleOwner) { (offers, errorMessage) ->
            if (errorMessage != null) {
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            } else {
                // Приводим типы к общему знаменателю
                offerFeedAdapter.offerList = ArrayList(offers?.map { it as Offer } ?: emptyList())
                offerFeedAdapter.notifyDataSetChanged()
            }
        }


    }

}