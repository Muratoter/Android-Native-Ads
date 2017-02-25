package com.muratoter.nativeads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Movie> movies=new ArrayList<Movie>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view_content);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        moviesLoad();
        adapter=new Adapter(this,movies);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void moviesLoad(){
        movies.add(new Movie("http://www.hdfilmizlemeli.net/uploads/film/2016/12/nefesini-tut-2016-turkce-dublajli-izle-1080p-673.jpg","Nefesini Tut","Kız kardeşi ve kendisi için daha iyi bir hayata başlamak isteyen Rocky, sevgilisi Money ve arkadaşı Alex ile zengin bir kör adamın sahip olduğu evin soygununa katılmayı kabul eder. Fakat kör adamın göründüğü gibi birisi olmadığını farkettiklerinde, adamın yeni kurbanları olmadan önce evden kaçmanın bir yolunu bulmak zorundadırlar."));
        movies.add(new Movie("http://media.sinematurk.com/film/3/1d/25893277f1eb/esaretinbedeli1.jpg","Esaretin Bedeli","Esaretin Bedeli (İngilizce: The Shawshank Redemption), Frank Darabont'un senaryosunu yazdığı ve yönettiği, başrollerinde Tim Robbins ve Morgan Freeman'ın yer aldığı 1994 yapımı Amerikan dram filmidir."));
        movies.add(new Movie("http://www.filmizledepo.com/uploads/film/2015/05/batman-kara-sovalye-389.jpg","Kara Şövalye","Kara Şövalye, Christopher Nolan'ın yönettiği bir süper kahraman filmidir. DC Comics'in kurgusal karakteri Batman'den uyarlanan 2005 tarihli Batman Başlıyor filminin devamıdır."));
        movies.add(new Movie("http://www.dizihdfilm1.net/uploads/film/2016/08/hababam-sinifi-sinifta-kaldi-full-tek-parca-hd-izle-144.jpg","Hababam Sınıfı","Hababam Sınıfı, yönetmenliğini Ertem Eğilmez'in üstlendiği, Rıfat Ilgaz'ın Hababam Sınıfı romanından uyarlanan 1975 çıkışlı Türk filmi."));
        movies.add(new Movie("https://upload.wikimedia.org/wikipedia/tr/archive/5/52/20110812044916!Hababam_S%C4%B1n%C4%B1f%C4%B1_S%C4%B1n%C4%B1fta_Kald%C4%B1.jpg","Hababam Sınıfı Sınıfta Kaldı","Hababam Sınıfı Sınıfta Kaldı, ilk filmin yapımından bir sene sonra vizyona giren film. Ertem Eğilmez'in yönetmenliğini ve yapımcılığını üstlendiği Rıfat Ilgaz'ın eserinden uyarlanmış serinin ikinci ve en çok hasılat yapan filmidir."));
        movies.add(new Movie("http://cdn.iksv.org/media/content/images/film/2012/large/61/SutKardesler_2.jpg","Süt Kardeşler","Süt Kardeşler, yönetmenliğini Ertem Eğilmez'in yaptığı, Hüseyin Rahmi Gürpınar'ın Gulyabani isimli romanından uyarlanan, 1976 yılı yapımı bir Türk filmidir."));
        movies.add(new Movie("https://pbs.twimg.com/profile_images/430424279881359360/7StrP7eI.jpeg","Tosun Paşa","Tosun Paşa, 1976 Kartal Tibet yapımı güldürü filmi. Tosun Paşa karakteri Ahmet Tosun Paşa'dan esinlenmedir."));

        //Reklam yerleştirme işlemi esnasında var olan içerik pozisyonun üzerine reklam yerleşir. Bu durumda reklam gelen indislerde kaydırma yapmak gerekiyor.
        //Bu yüzden reklam gelen indislere kukla bir nesne ekleyerek tüm içeriklerin düzgün sekilde gösterilmesi sağlamıştır.
        for(int i=0;i<movies.size();i++){
            if(i>0 && i%3==0){
                movies.add(i,new Movie("https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg","null","null"));
            }
        }
        //--
    }
}
