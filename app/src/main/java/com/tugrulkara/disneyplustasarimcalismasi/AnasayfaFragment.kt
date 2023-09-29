package com.tugrulkara.disneyplustasarimcalismasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.tugrulkara.disneyplustasarimcalismasi.databinding.FragmentHomeBinding

class AnasayfaFragment : Fragment() {

    private lateinit var carouselFilmlerListesi : ArrayList<Filmler>
    private lateinit var oneCikanFilmlerListesi : ArrayList<Filmler>
    private lateinit var enCokIzlenenFilmlerListesi : ArrayList<Filmler>
    private lateinit var onerilenFilmlerListesi : ArrayList<Filmler>
    private lateinit var sadeceDisneyFilmlerListesi : ArrayList<Filmler>

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        getData()
        initRecycler()

        return binding.root
    }


    private fun getData(){

        carouselFilmlerListesi = ArrayList<Filmler>()
        val f1 = Filmler(1,"Kaçış","kacis")
        val f2 = Filmler(2,"Ms Marvel","msmarvel")
        val f3 = Filmler(3,"Secret Invasion","secretinvasion")
        val f4 = Filmler(4,"Wakanda","wakanda")
        val f5 = Filmler(5,"Free Guy","freeguy")
        val f6 = Filmler(6,"Luka","luka")
        carouselFilmlerListesi.add(f1)
        carouselFilmlerListesi.add(f2)
        carouselFilmlerListesi.add(f3)
        carouselFilmlerListesi.add(f4)
        carouselFilmlerListesi.add(f5)
        carouselFilmlerListesi.add(f6)

        oneCikanFilmlerListesi = ArrayList<Filmler>()
        val o1 = Filmler(1,"Free Guy","freeguyposter")
        val o2 = Filmler(2,"Luka","lukaposter")
        val o3 = Filmler(3,"Wakanda","wakandaposter")
        val o4 = Filmler(4,"Kaçış","kacisposter")
        val o5 = Filmler(5,"Ms Marvel","msmarvelposter")
        val o6 = Filmler(6,"Secret Invasion","secretinvasionposter")
        oneCikanFilmlerListesi.add(o1)
        oneCikanFilmlerListesi.add(o2)
        oneCikanFilmlerListesi.add(o3)
        oneCikanFilmlerListesi.add(o4)
        oneCikanFilmlerListesi.add(o5)
        oneCikanFilmlerListesi.add(o6)

        onerilenFilmlerListesi = ArrayList<Filmler>()
        val oF1 = Filmler(1,"Mandolarian","mandolarianposter")
        val oF2 = Filmler(2,"Secret Invasion","secretinvasionposter")
        val oF3 = Filmler(3,"Kaçış","kacisposter")
        val oF4 = Filmler(4,"Thor","thorposter")
        val oF5 = Filmler(5,"Ms Marvel","msmarvelposter")
        val oF6 = Filmler(6,"Rebelle","rebelleposter")
        onerilenFilmlerListesi.add(oF1)
        onerilenFilmlerListesi.add(oF2)
        onerilenFilmlerListesi.add(oF3)
        onerilenFilmlerListesi.add(oF4)
        onerilenFilmlerListesi.add(oF5)
        onerilenFilmlerListesi.add(oF6)

        sadeceDisneyFilmlerListesi = ArrayList<Filmler>()
        val sD1 = Filmler(1,"Ms Marvel","msmarvelposter")
        val sD2 = Filmler(2,"Rebelle","rebelleposter")
        val sD3 = Filmler(3,"Mandolarian","mandolarianposter")
        val sD4 = Filmler(4,"Secret Invasion","secretinvasionposter")
        val sD5 = Filmler(5,"Thor","thorposter")
        val sD6 = Filmler(6,"Wakanda","wakandaposter")
        sadeceDisneyFilmlerListesi.add(sD1)
        sadeceDisneyFilmlerListesi.add(sD2)
        sadeceDisneyFilmlerListesi.add(sD3)
        sadeceDisneyFilmlerListesi.add(sD4)
        sadeceDisneyFilmlerListesi.add(sD5)
        sadeceDisneyFilmlerListesi.add(sD6)

        enCokIzlenenFilmlerListesi = ArrayList<Filmler>()
        val e1 = Filmler(1,"Amsterdam","amsterdamposter")
        val e2 = Filmler(2,"Free Guy","freeguyposter")
        val e3 = Filmler(3,"Thor","thorposter")
        val e4 = Filmler(4,"Kaçış","kacisposter")
        val e5 = Filmler(5,"Secret Invasion","secretinvasionposter")
        val e6 = Filmler(6,"Wakanda","wakandaposter")
        enCokIzlenenFilmlerListesi.add(e1)
        enCokIzlenenFilmlerListesi.add(e2)
        enCokIzlenenFilmlerListesi.add(e3)
        enCokIzlenenFilmlerListesi.add(e4)
        enCokIzlenenFilmlerListesi.add(e5)
        enCokIzlenenFilmlerListesi.add(e6)

    }

    private fun initRecycler(){

        val carouselAdapter = CarouselAdapter(requireContext(),carouselFilmlerListesi)
        binding.carouselViewPager.offscreenPageLimit = 3
        binding.carouselViewPager.setPageTransformer(getTransformation())
        binding.carouselViewPager.adapter = carouselAdapter
        binding.carouselViewPager.currentItem = 1
        onInfinitePageChangeCallback(carouselFilmlerListesi.size + 2)

        binding.oneCikanlarRv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val oneCikanlarAdapter = OneCikanlarAdapter(requireContext(),oneCikanFilmlerListesi)
        binding.oneCikanlarRv.adapter = oneCikanlarAdapter

        binding.onerilerRv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val onerilenlerAdapter = OnerilenlerAdapter(requireContext(),onerilenFilmlerListesi)
        binding.onerilerRv.adapter = onerilenlerAdapter

        binding.sadeceDisneyRv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val sadeceDisneyAdapter = SadeceDisneyAdapter(requireContext(),sadeceDisneyFilmlerListesi)
        binding.sadeceDisneyRv.adapter = sadeceDisneyAdapter

        binding.enCokIzlenenlerRv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val enCokIzlenenlerAdapter = EnCokIzlenenlerAdapter(requireContext(),enCokIzlenenFilmlerListesi)
        binding.enCokIzlenenlerRv.adapter = enCokIzlenenlerAdapter
    }

    private fun getTransformation() : CompositePageTransformer {
        val transform = CompositePageTransformer()
        transform.addTransformer(MarginPageTransformer(30))
        transform.addTransformer { page, position ->
            page.scaleY = 0.85f + (1 - kotlin.math.abs(position)) * 0.15f
        }
        return transform
    }

    private fun onInfinitePageChangeCallback(listSize: Int) {
        binding.carouselViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    when (binding.carouselViewPager.currentItem) {
                        listSize - 1 -> binding.carouselViewPager.setCurrentItem(1, false)
                        0 -> binding.carouselViewPager.setCurrentItem(listSize - 2, false)
                    }
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position != 0 && position != listSize - 1) {
                }
            }
        })
    }

}