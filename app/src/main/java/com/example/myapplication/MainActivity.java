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
        filmList.add(new Film("I3S_CBJgwbs", "3 chú lợn con","Thang Hoang","250p","10/02/2023","Thiếu Nhi","Mỹ"));
        filmList.add(new Film("dGNmaN1CI9Q", "cay hai","Thang Hoang","250p","10/02/2023","Thiếu Nhi","Mỹ"));
        filmList.add(new Film("dGNmaN1CI9Q", "thinh nghien","Thang Hoang","250p","10/02/2023","hai huoc","Mỹ"));
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
        intent.putStringArrayListExtra("film", filmDetail);
        startActivity(intent);
    }


}