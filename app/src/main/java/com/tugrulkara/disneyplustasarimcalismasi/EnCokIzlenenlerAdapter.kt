package com.tugrulkara.disneyplustasarimcalismasi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tugrulkara.disneyplustasarimcalismasi.databinding.ItemFilmBinding

class EnCokIzlenenlerAdapter(var mContext : Context, var filmList : ArrayList<Filmler>) : RecyclerView.Adapter<EnCokIzlenenlerAdapter.FilmViewHolder>() {

    inner class FilmViewHolder(var binding: ItemFilmBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = ItemFilmBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = filmList.get(position)
        val t = holder.binding

        t.imageViewFilm .setImageResource(mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName))
    }

    override fun getItemCount(): Int {
        return filmList.size
    }
}