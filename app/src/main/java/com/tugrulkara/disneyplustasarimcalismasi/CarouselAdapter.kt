package com.tugrulkara.disneyplustasarimcalismasi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tugrulkara.disneyplustasarimcalismasi.databinding.ItemCarouselBinding

class CarouselAdapter(var mContext:Context, var filmList:ArrayList<Filmler>) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    inner class CarouselViewHolder(var binding:ItemCarouselBinding) : RecyclerView.ViewHolder(binding.root)

    private val newList: List<Filmler> =
        listOf(filmList.last()) + filmList + listOf(filmList.first())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val binding = ItemCarouselBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CarouselViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val film = newList.get(position)
        val t = holder.binding

        t.carouselImageView.setImageResource(mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName))
    }

    override fun getItemCount(): Int {
        return newList.size
    }

}