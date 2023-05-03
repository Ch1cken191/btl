package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
        filmList.add(new Film("B1tFAPVIG8c", "Máy Bay Mất Tích","Jeff Rake","180p","11/07/2015","Kinh dị","Mỹ","Một chuyến bay khởi hành nhiều năm trước giờ mới hạ cánh một cách khó hiểu. Hành khách trở về phải đối mặt với thực tại mới lạ lẫm khi mọi chuyện đã tiếp diễn mà không có họ."));
        filmList.add(new Film("vmM2RbRzRUM", "Phép màu đã cho ta gặp nhau","Kim Hyun Joo","200p","10/02/2023","Tình Cảm","Hàn Quốc","phim tình cảm pha lẫn yếu tố viễn tưởng do đạo diễn Lee Hyeong Min hợp tác cùng nhà biên kịch Baek Mi Kyeong, phim có nội dung xoay quanh người đàn ông Song Hyun Cheol A, sau một lần bị tai nạn xe trải qua được cơn nguy kịch trở về nhưng không may khi tỉnh dậy thì anh phát hiện thân xác đó chính là mình, nhưng không thể điều khiển được tinh thần, cứ như là có người khác đã xâm chiếm vào cơ thể của mình. Sau khi xuất viện, Song Hyun-Cheol A phải đối mặt với tình huống éo le và bất đắc dĩ là bỗng trở thành người đàn ông của hai gia đình khác nhau và đau đầu khi gặp phải 2 người vợ khiến cho anh phải khó xử rất nhiều trong phim."));
        filmList.add(new Film("egwCJMkFmHU", "Big Mouth","Oh Choong Hwan","220p","04/06/2021","Hành Động","Hàn Quốc","Luật Sư Hắc Hóa kể về Park Chang Ho (Lee Jong Suk) là một luật sư hạng bét, không có năng lực nhưng phụ trách một vụ án giết người. Từ đó, anh bắt đầu nhận ra những sự thật bị che giấu từ bấy lâu nay và buộc phải trở nên ác độc để bảo vệ bản thân, gia đình và trừng phạt tội ác của phe đối địch."));
        filmList.add(new Film("cwI_1BA8GsI", "Vượt Ngục","Thang Hoang","250p","16/10/2019","Hành Động","Mỹ","Bộ Phim nói Về một vụ vượt ngục để trả thù cá nhân của một tù nhân bị bắt oan"));
        filmList.add(new Film("3EMLAGgN7b0", "Quái xế","Edgar Wright","120p","18/6/2017","Hành Động","Vương Quốc Anh","Baby Driver là bộ phim hành động tội phạm năm 2017 do Edgar Wright viết kịch bản và đạo diễn. Phim có dàn diễn viên gồm Ansel Elgort, Kevin Spacey, Lily James, Eiza González, Jon Hamm, Jamie Foxx và Jon Bernthal. Cốt truyện xoay quanh Baby, một tài xế trẻ tuổi đang tìm cách chạy trốn khỏi chính cái bóng tội lỗi của bản thân mình.\n" +
                "Baby Driver là sản phẩm do hãng phim Working Title Films, Big Talk Productions và Media Rights Capital đồng sản xuất, Sony Pictures phân phối trên toàn thế giới và TriStar Pictures phân phối tại Hoa Kỳ. Tác phẩm được công chiếu tại South by Southwest vào ngày 11 tháng năm 2017 và chính thức ra rạp vào ngày 28 tháng 6 năm 2017. Sau khi phát hành, tác phẩm đã nhận nhiều lời ca ngợi từ giới phê bình và thu về $226,6 triệu USD trên toàn thế giới (so với chi phí sản xuất $34 triệu USD), qua đó trở thành bộ phim có doanh thu cao nhất của đạo diễn Wright.\n"));
        filmList.add(new Film("nCoBpyj7qz4", "John weak","Chad Stahelski","180p","24/03/2023","Hành Động","Mỹ","John Wick là một loạt tác phẩm giả tưởng thuộc thể loại hành động giật gân của Mỹ, được tạo ra bởi Derek Kolstad và thuộc sở hữu của Summit Entertainment. Nhân vật chính của sê-ri là John Wick (Keanu Reeves thủ vai), một cựu sát thủ lên đường trả thù những kẻ đã trộm xe và giết hại chú chó cưng của mình.\n" +
                "Loạt tác phẩm bắt đầu vào năm 2014 khi bộ phim Sát thủ John Wick được phát hành, sau đó là hai phần nối tiếp, Sát thủ John Wick: Phần 2 vào ngày 10 tháng 2 năm 2017 và Sát thủ John Wick: Phần 3 - Chuẩn bị chiến tranh vào ngày 17 tháng 5 năm 2019. Cả ba bộ phim đều thành công về mặt thương mại, với tổng doanh thu hơn 581 triệu đô la trên toàn thế giới. Phần phim thứ tư, John Wick: Chapter 4, hiện đang được phát hành năm 2023."));
        filmList.add(new Film("Qt7OgOB_TVU", "hành tinh khỉ","Matt Reeves","188p","11/07/2014","Kinh dị","Mỹ","Andy Serkis, Jason Clarke, Gary Oldman, Keri Russell, Toby Kebbell, Terry Notary.\n" +
                "mô tả: Dawn of the Planet of the Apes là một bộ phim khoa học viễn tưởng Mỹ công chiếu năm 2014. Phim được đạo diễn bởi Matt Reeves và viết kịch bản bởi Mark Bomback, Rick Jaffa và Amanda Silver. Dàn diễn viên tham gia bao gồm Andy Serkis, Jason Clarke, Gary Oldman, Keri Russell, Toby Kebbell và Kodi Smit-McPhee"));
        filmList.add(new Film("X-ZxnHqpnaI", "Safe","Boaz Yakin","256p","18/01/2021","Gia Đình","Trung Quốc","Safe bắt đầu từ Mei, một cô bé Trung Quốc 12 tuổi nhưng nắm giữ trong trí óc một mật mã vô giá và là mục tiêu truy đuổi của Hội Tam Hoàng, mafia Nga cũng như cả những quan chức tham nhũng của New York. Để giải cứu cô bé và trả thù những kẻ đã hủy hoại cuộc đời mình, Luke - một cựu cảnh sát đã tình cờ nhận lấy một điệp vụ kép: dấn thân vào cuộc chiến đầy cam go để giải cứu Mei và bảo vệ bí mật mà cô bé đang nắm giữ. Luke sẽ đối phó với đối thủ nguy hiểm này như thế nào?"));
        filmList.add(new Film("p32dUJrpZ1I", "Điều kì ờ phòng giam số 7","Oh Dal-su","192p","10/06/2013","Tình Cảm","Hàn Quốc","Bộ phim kể về câu chuyện tình cảm cha con đẫm nước mắt của người đàn ông bị vu oan bởi tên sát nhân, dẫn đến việc phải nhận lấy án tử và cô con gái nhỏ tuổi của mình. Ước mơ cuối đời của người cha này chính là được gặp lại đứa con bé bỏng. Những người bạn trong phòng giam số 7 đã nghĩ cách để hiện thực hóa ước mơ nhỏ bé này của người đàn ông tội nghiệp. "));
        filmList.add(new Film("8GEzNGcP1JA", "Mùa Hè Yêu Dấu Của Chúng Ta","Choi Woo Sik","128p","02/03/2021","Tình Cảm","Hàn Quốc"," Đây là bộ phim tình cảm mới được cho ra mắt nhưng nhận được nhiều sự quan tâm từ khán giả. Sự kết hợp ăn ý, tạo nhiều “phản ứng hóa học” đặc sắc trên màn ảnh nhỏ của cặp đôi nam - nữ chính đã giúp bộ phim có được nhiều lượt đánh giá cao trên các trang review. Phim là câu chuyện tình yêu hợp rồi tan của cặp đôi trẻ tuổi đang trong cuộc hành trình đi tìm định nghĩa cho cuộc đời mình. "));
        filmList.add(new Film("sVS_9dtmfmE", "Hạ Cánh Nơi Anh","Hyun Bin","1080p","19/02/2020","Hài Hước","Mỹ","Hạ cánh nơi anh là bộ phim tình cảm lấy cảm hứng từ hình ảnh người quân nhân Hàn Quốc và cô nàng tiểu thư tài phiệt xinh đẹp. Chuyện tình cảm của họ diễn ra thật tình cờ, từ hai con người xa ạ thuộc hai thế giới khác nhau, họ gặp gỡ và yêu nhau Xuyên suốt bộ phim là những khung cảnh đầy ngọt ngào khiến người xem phải “hú hét” khi theo dõi câu chuyện “gà bông” này. "));
        filmList.add(new Film("YN6E-9aDzic", "One Piece","Konosuke Uda","526p","20/10/1999","Anime","Nhật Bản","One Piece là series anime được sản xuất dựa trên tác phẩm manga cùng tên. Bộ phim này luôn nằm trong top anime được người xem yêu thích và đánh giá cao bởi nội dung trung thành với nguyên tác. \n" +
                "Nội dung của câu chuyện bắt đầu từ cái chết của Vua Hải Tặc Gol D.Roger, tên cướp biển hùng mạnh và khét tiếng nhất mọi thời đại. Trước khi bị giết bởi Chính phủ Thế giới, hắn đã tiết lộ vị trí của kho báu lớn nhất thế giới, One Piece. Thông tin này đã mở ra thời đại mới cho rất nhiều hải tặc, những kẻ mong muốn tìm thấy One Piece để chiếm lấy của cải và danh hiệu Vua Hải Tặc vĩ đại.\n" +
                "Monkey D.Luffy, nhân vật chính của bộ phim là một cậu bé 17 tuổi, người đã phá vỡ mọi định nghĩa tiêu chuẩn về một tên cướp biển. Thay vì hình ảnh độc ác, giết người, cướp bóc để mua vui thường thấy, mục đích làm cướp biển của Luffy là để phiêu lưu đến những vùng đất mới, gặp gỡ những con người thú vị, và tìm kiếm One Piece.\n" +
                "Theo bước chân của Shanks, người anh hùng thơ ấu của mình, Luffy và thủy thủ đoàn đã đi khắp Đại Hải Trình, trải qua những chuyến phiêu lưu mạo hiểm, khám phá những bí ẩn đen tối và chiến đấu với những kẻ thù mạnh mẽ. Tất cả đều được kể trong One Piece – top anime được yêu thích nhất mọi thời đại!"));
        filmList.add(new Film("HeZPEq6eJd0", "Cửu Vĩ Hồ","Kishimoto Masashi","2160p","3/10/2002","Anime","Nhật Bản","Vào ngày Naruto Uzumaki ra đời, ngôi làng Konoha đã bị Cửu Vĩ Hồ tấn công. Để bảo vệ ngôi làng, cha của Naruto, Hokage Đệ Tứ Namikaze Minato đã hy sinh tính mạng và phong ấn Cửu Vĩ Hồ trong cơ thể đứa con mới ra đời của mình. \n" +
                "13 năm sau, Naruto tốt nghiệp Học viện ninja với mục tiêu trở thành Hokage của làng. Đồng hành cùng cậu là Sasuke Uchiha, người cố gắng đạt được sức mạnh để trả thù cho gia tộc mình sau khi họ bị anh trai Itachi sát hại. Bên cạnh đó, còn có Sakura Haruno, người Naruto thầm thương, nhưng cô không chú ý đến cậu mà lại trộm nhớ Sasuke.\n" +
                "Khi Itachi trở về làng sau kỳ thi Chūnin, Sasuke nhận ra mình quá yếu và quyết định tìm đến nhân vật phản diện Orochimaru để mưu cầu sức mạnh. Naruto phải làm mọi cách để ngăn người bạn của mình khỏi cảnh đánh mất bản thân vào tay kẻ ác."));
        filmList.add(new Film("9JWyhyA8wug", "Đại Chiến TiTan","Shinji Higuchi","720p","7/4/2013","Anime","Nhật Bản","Nhiều thế kỷ trước, nhân loại gần như bị tuyệt chủng do các cuộc tàn sát từ loài sinh vật khổng lồ có tên Titan. Để sống sót, con người buộc phải ẩn mình sau những bức tường thành to lớn. \n" +
                "Để tiếp tục tồn tại, những người sống sót đã xây dựng hàng loạt các bức tường phòng thủ. Do đó, trong gần một trăm năm không có bất kỳ cuộc chạm trán nào giữa hai giống loài. Tuy nhiên, sự bình yên mong manh này đã bị xé toạc khi một gã Titan cố gắng phá vỡ bức tường được cho là bất khả xâm phạm. Cuộc chiến sinh tồn chống lại những kẻ ăn thịt người lại một lần nữa bắt đầu. \n" +
                "Sau khi chứng kiến cái chết của mẹ dưới sự tàn sát của Titan, Eren Yeager đã quyết tâm phải diệt trừ chúng. Cậu gia nhập vào Quân Trinh sát, một đội quân tinh nhuệ được thành lập với mục đích chống lại các Titan. Eren, cùng với em gái nuôi Mikasa  người bạn thời thơ ấu của mình Ackerman đã tham gia các cuộc chiến tàn khốc, và chạy đua để tìm ra cách đánh bại Titan trước khi lớp tường bảo vệ bị phá vỡ."));
        filmList.add(new Film("qY_tEXxgJg8", "Điện thoại Đen","Scott Derrickson","102p","23/06/2022","Kinh dị","Mỹ","The Black Phone là một dự án kinh dị tiềm năng khi sử dụng đề tài giật gân với thông điệp \"Đừng nói chuyện với người lạ\". Năm 1978, 5 đứa trẻ đột nhiên biến mất ở North Carolina. Finney Shaw 13 tuổi khôn ngoan và nhút nhát đã bị bắt cóc bởi một kẻ sát nhân máu lạnh và trở thành nạn nhân thứ 6 bị mắc kẹt trong một tầng hầm cách âm. Cậu bé hét lên để được giúp đỡ, nhưng không ai nghe cậu. Đột nhiên, một chiếc điện thoại vỡ trên tường vang lên, và cậu nhận ra rằng có thể nghe thấy giọng nói của những nạn nhân khác, người cũng từng bị mắc kẹt dưới tầng hầm. Họ cố gắng giúp Finney thoát khỏi vòng vây của kẻ sát nhân. Liệu cậu bé có trốn thoát và trở về nhà an toàn?\n"));
        filmList.add(new Film("f-SgRsJ9tt4", "Ma Gương 3","Rizal Mantovani","105p","02/12/2010","Kinh dị","Mỹ","Dinda muốn có thể kiểm soát sức mạnh của mình, vì vậy cô đã theo học tại Trường Matahati, nơi những đứa trẻ có sức mạnh đặc biệt học cách kiểm soát sức mạnh của mình, nhưng những nguy hiểm bất ngờ luôn ở khắp mọi nơi và mọi bước của chúng liên tục xảy đến. Dinda có thể sống sót ở đó không?"));
        filmList.add(new Film("KxMMYKkVbwA", "Halloween chết chóc","David Gordon Green","146p","16/10/2021","Kinh DỊ","Mỹ","Series phim kinh dị Halloween sắp cho ra mắt phần thứ 12 đầy kịch tích vào tháng 10/2021. Bộ phim là phần nối tiếp của Halloween năm 2018. Nội dung bắt đầu vào ngày lễ Halloween với màn đêm tăm tối đang buông xuống, một nhóm bạn đã gặp phải ngôi nhà ma ám hứa hẹn sẽ đem đến những nỗi sợ hãi đen tối nhất của họ. "));
        filmList.add(new Film("hJofTkJFW3g", "Lưu Manh Đổi đời","Cao Hiểu Phàn","218p","29/11/2015","Hài Hước","Trung Quốc","LƯU MANH ĐỔI ĐỜI kể về cặp anh em ruột Trịnh Hảo và Trịnh Trọng là lưu manh tiếng xấu vang xa, bị cám dỗ bởi số tiền thưởng cực lớn từ show thực tế, họ bắt đầu thay đổi bản thân và vô tình vướng vào một âm mưu bí ẩn"));
        filmList.add(new Film("_waP3LkdzuA", "Tân Ô Long Viện","Chu Diên Bình","170p","19/03/2012","Hài Hước","Trung Quốc","Bộ phim sẽ đưa khán giả quay lại với kí ức về một Ô Long Viện với những trò nghịch ngợm quỷ quái của các chú tiểu.Trong phần này, Ô Long Viện mở một đợt nhập môn, nhưng một số đối tượng xấu lợi dụng cơ hội này để tìm cách đột nhập và gây một số bất lợi cho Ô Long Viện"));
        filmList.add(new Film("92a7Hj0ijLs", "Hàng Xóm của tôi là TotoRo","Hayao Miyazaki","86p","01/06/1988","Thiếu Nhi","Nhật Bản","Những thước phim trong sáng, nhẹ nhàng về tình cảm gia đình và bạn bè, phù hợp với mọi lứa tuổi. Bộ phim xoay quanh hai chị em Satsuki và Mei bắt gặp Totoro với thân hình to lớn, đáng yêu và bộ lông mềm mại. Họ nhanh chóng trở thành bạn bè với nhau, Totoro còn giúp đỡ 2 chị em gặp người mẹ yêu dấu của họ.\n" +
                "Cốt truyện nhẹ nhàng, tình cảm mang đến những giây phút thư giãn về tình cảm gắn kết giữa con người và thiên nhiên. Nội dung phù hợp với mọi độ tuổi, luôn nằm trong top phim hoạt hình hay nhất mọi thời đại.\n"));
        filmList.add(new Film("rkKaYQU6vCw", "Vút Bay","Pete Docter","96p","01/06/2000","Thiếu Nhi","Mỹ","Bộ phim hoạt hình kinh điển Up đã nhận được nhiều giải thưởng danh giá và cơn mưa lời khen từ giới phê bình. Cốt truyện xoay quanh một ông lão góa vợ Carl Fredricksen với tạo hình chiếc đầu vuông đặc trưng và cậu bé Russell là hướng đạo sinh kiêm nhà thám hiểm.\n" +
                "Họ cùng nhau lên đường tới thác Paradise để thực hiện nguyện vọng của người vợ quá cố. Với phương tiện di chuyển đặc biệt là chiếc khinh khí cầu được tạo lên từ căn nhà cũ và chùm bóng bay khổng lồ rực rỡ. Hành trình của họ còn đặc biệt hơn với nhiều biến cố bất ngờ.  "));


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
                Intent inte = new Intent(MainActivity.this,Profile.class);
                startActivity(inte);
                finish();
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
    //    Film film = filmList.get(position);
        Film film = (Film) filmAdapter.list.get(position);
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