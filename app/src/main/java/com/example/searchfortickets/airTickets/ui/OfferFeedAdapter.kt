package com.example.searchfortickets.airTickets.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.searchfortickets.R
import com.example.searchfortickets.airTickets.domain.models.Offer
import com.example.searchfortickets.databinding.ItemsOfferFeedBinding

class OfferFeedAdapter:RecyclerView.Adapter<OfferFeedAdapter.OfferFeedViewHolder>() {
    var offerList = ArrayList<Offer>()

    inner class OfferFeedViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemsOfferFeedBinding.bind(item)

        fun bind(offer: Offer) = with(binding) {
            title.text =offer.title
            location.text = offer.town
            price.text = "от ${offer.price.value} ₽"
            val imageName = "offer_${offer.id}"

            val imageResId = itemView.context.resources.getIdentifier(imageName, "drawable", itemView.context.packageName)

            Glide.with(itemView.context)
                .load(imageResId)
                .centerCrop()
                .transform(RoundedCorners(10))
                .into(profileImage)

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OfferFeedAdapter.OfferFeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_offer_feed, parent, false)
        return OfferFeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferFeedAdapter.OfferFeedViewHolder, position: Int) {
        holder.bind(offerList[position])
    }

    override fun getItemCount(): Int = offerList.size
}