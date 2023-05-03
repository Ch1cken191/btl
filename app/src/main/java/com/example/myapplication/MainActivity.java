package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Film> filmList;
    FilmAdapter filmAdapter;
    ListView listView;
    Button categoryBtn;
    SearchView searchView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Home");
//        actionBar.setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.filmList);
        filmList = new ArrayList<>();

//        filmList.add(new Film("bxEw6yJBeL0",))
//        filmList.add(new Film("I3S_CBJgwbs","https://img.youtube.com/vi/I3S_CBJgwbs/sddefault.jpg","Người Rơi","Thang Hoang","250p","10/02/2023","Hành Động","Anh"));
        filmList.add(new Film("B1tFAPVIG8c", "Máy Bay Mất Tích","Jeff Rake","180p","11/07/2015","Kinh dị","Mỹ","Phim rất hay"));
        filmList.add(new Film("vmM2RbRzRUM", "Phép màu đã cho ta gặp nhau","Kim Hyun Joo","200p","10/02/2023","Tình Cảm","Hàn Quốc",""));
        filmList.add(new Film("egwCJMkFmHU", "Big Mouth","Oh Choong Hwan","220p","04/06/2021","Hành Động","Hàn Quốc",""));
        filmList.add(new Film("cwI_1BA8GsI", "Vượt Ngục","Thang Hoang","250p","16/10/2019","Hành Động","Mỹ",""));
        filmList.add(new Film("3EMLAGgN7b0", "Quái xế","Edgar Wright","120p","18/6/2017","Hành Động","Vương Quốc Anh",""));
        filmList.add(new Film("nCoBpyj7qz4", "John weak","Chad Stahelski","180p","24/03/2023","Hành Động","Mỹ",""));
        filmList.add(new Film("Qt7OgOB_TVU", "hành tinh khỉ","Matt Reeves","188p","11/07/2014","Kinh dị","Mỹ",""));
        filmList.add(new Film("X-ZxnHqpnaI", "Safe","Boaz Yakin","256p","18/01/2021","Gia Đình","Trung Quốc",""));
        filmList.add(new Film("p32dUJrpZ1I", "Điều kì ờ phòng giam số 7","Oh Dal-su","192p","10/06/2013","Tình Cảm","Hàn Quốc",""));
        filmList.add(new Film("8GEzNGcP1JA", "Mùa Hè Yêu Dấu Của Chúng Ta","Choi Woo Sik","128p","02/03/2021","Tình Cảm","Hàn Quốc",""));
        filmList.add(new Film("sVS_9dtmfmE", "Hạ Cánh Nơi Anh","Hyun Bin","1080p","19/02/2020","Hài Hước","Mỹ",""));
        filmList.add(new Film("YN6E-9aDzic", "One Piece","Konosuke Uda","526p","20/10/1999","Anime","Nhật Bản",""));
        filmList.add(new Film("HeZPEq6eJd0", "Cửu Vĩ Hồ","Kishimoto Masashi","2160p","3/10/2002","Anime","Nhật Bản",""));
        filmList.add(new Film("9JWyhyA8wug", "Đại Chiến TiTan","Shinji Higuchi","720p","7/4/2013","Anime","Nhật Bản",""));
        filmList.add(new Film("qY_tEXxgJg8", "Điện thoại Đen","Scott Derrickson","102p","23/06/2022","Kinh dị","Mỹ",""));
        filmList.add(new Film("f-SgRsJ9tt4", "Ma Gương 3","Rizal Mantovani","105p","02/12/2010","Kinh dị","Mỹ",""));
        filmList.add(new Film("KxMMYKkVbwA", "Halloween chết chóc","David Gordon Green","146p","16/10/2021","Kinh DỊ","Mỹ",""));
        filmList.add(new Film("hJofTkJFW3g", "Lưu Manh Đổi đời","Cao Hiểu Phàn","218p","29/11/2015","Hài Hước","Trung Quốc",""));
        filmList.add(new Film("_waP3LkdzuA", "Tân Ô Long Viện","Chu Diên Bình","170p","19/03/2012","Hài Hước","Trung Quốc",""));
        filmList.add(new Film("92a7Hj0ijLs", "Hàng Xóm của tôi là TotoRo","Hayao Miyazaki","86p","01/06/1988","Thiếu Nhi","Nhật Bản",""));
        filmList.add(new Film("rkKaYQU6vCw", "Vút Bay","Pete Docter","96p","01/06/2000","Thiếu Nhi","Mỹ",""));


        filmAdapter = new FilmAdapter(MainActivity.this,R.layout.film_item_layout,filmList);
        listView.setAdapter(filmAdapter);

        selectFilm();
        categoryBtn = findViewById(R.id.categoryBtn);
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCategoryMenu();
            }
        });

    }

    // hien thi the loai phim
    private void showCategoryMenu(){
        PopupMenu popupMenu = new PopupMenu(this,categoryBtn);
        popupMenu.getMenuInflater().inflate(R.menu.category_popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.all_catogory:
                        filmAdapter.filterFilm(filmList,"","category");
                        break;
                    case R.id.action_category:
                        filmAdapter.filterFilm(filmList,"Hành Động","category");
                        break;
                    case R.id.family_category:
                        filmAdapter.filterFilm(filmList,"Gia Đình","category");
                        break;
                    case R.id.humorous_category:
                        filmAdapter.filterFilm(filmList,"Hài Hước","category");
                        break;
                    case R.id.emotional_category:
                        filmAdapter.filterFilm(filmList,"Tình Cảm","category");
                        break;
                    case R.id.horrified_category:
                        filmAdapter.filterFilm(filmList,"Kinh dị","category");
                        break;
                    case R.id.anime_category:
                        filmAdapter.filterFilm(filmList,"Anime","category");
                        break;
                    case R.id.kids_category:
                        filmAdapter.filterFilm(filmList,"Thiếu nhi","category");
                        break;
                    case R.id.adult_category:
                        filmAdapter.filterFilm(filmList,"18+","category");
                        break;
                }
                filmAdapter.notifyDataSetChanged();
                return false;
            }
        });
        popupMenu.show();
    }

    // khi chon film bat ki trong ds
    private void selectFilm() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openFilmDetail(position);
            }
        });
    }

//    set up menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);

        MenuItem  menuItem = menu.findItem(R.id.searchBtn);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filmAdapter.filterFilm(filmList,newText,"name");
                filmAdapter.notifyDataSetChanged();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    // khi chon item trong menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                Toast.makeText(this,"Ban chon profile",Toast.LENGTH_LONG).show();

                break;
            case R.id.favoriteFilm:
                Toast.makeText(this,"Ban chon favorite",Toast.LENGTH_LONG).show();

                break;
            case R.id.logOutBtn:
                Toast.makeText(this,"Ban chon log out",Toast.LENGTH_LONG).show();
                Intent intent =  new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();

                break;
            case R.id.searchBtn:
//                Toast.makeText(this,"Ban chon search",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openFilmDetail(int position){
        Intent intent = new Intent(MainActivity.this, FilmDetail.class);
        Film film = filmList.get(position);
        ArrayList<String> filmDetail = new ArrayList<>();
        filmDetail.add(film.getId());
        filmDetail.add(film.getName());
        filmDetail.add(film.getDirector());
        filmDetail.add(film.getDuration());
        filmDetail.add(film.getNation());
        filmDetail.add(film.getReleaseDate());
        filmDetail.add(film.getCategory());
        filmDetail.add(film.getDescription());
        intent.putStringArrayListExtra("film", filmDetail);
        startActivity(intent);
    }


}