package com.example.fragmentsample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static class PageListFragment  extends ListFragment {
        boolean mTwoPane;	// when large screen
        int mCurCheckPosition = 0;

    	public static final String[][] PAGELIST = {
    		{ "タイトル","河口湖　伊藤左千夫" },
    		{ "ページ１","　段ばしごがギチギチ音がする。まもなくふすまがあく。" +
    				"茶盆をふすまの片辺（かたべ）へおいて、すこぶるていねいにおじぎをした女は宿の娘らしい。" +
    				"霜枯れのしずかなこのごろ、空もしぐれもようで湖水の水はいよいよおちついて見える。" +
    				"しばらく客というもののなかったような宿のさびしさ。" +
    				"\n　娘は茶をついで予（よ）にすすめる。年は二十（はたち）ばかりと見えた。" +
    				"紅蓮（ぐれん）の花びらをとかして彩色したように顔が美しい。" +
    				"わりあいに顔のはば広く、目の細いところ、土佐絵などによく見る古代女房（こだいにょうぼう）の顔を" +
    				"ほんものに見る心持ちがした。" +
    				"富士のふもと野の霜枯れをたずねてきて、さびしい宿屋に天平式（てんぴょうしき）美人を見る、" +
    				"おおいにゆかいであった。" +
    				"\n　娘は、お中食（ちゅうじき）のしたくいたしましょうかといったきり、あまり口数をきかない、" +
    				"予は食事してからちょっと鵜島（うじま）へゆくから、舟をたのんでくれと命じた。" },
    		{ "ページ２","　富士のすそ野を見るものはだれもおなじであろう、かならずみょうに隔世的夢幻（かくせいてきむげん）の感に" +
    				"うたれる。この朝予は吉田の駅をでて、とちゅう畑のあいだ森のかげに絹織の梭（ひ）の音を聞きつつ、" +
    				"やがて大噴火当時そのままの石の原にかかった。千年の風雨も化力（かりょく）をくわうることができず、" +
    				"むろん人間の手もいらず、一木（ぼく）一草（そう）もおいたたぬ、" +
    				"ゴツゴツたる石の原を半里あまりあるいた。" +
    				"富士はほとんど雲におおわれて傾斜遠長（とおなが）きすそばかり見わたされる。" +
    				"目のさきからじきに山すそに連続した、三、四里もある草木（そうもく）あるいは石の原などをひと目に見わたすと、" +
    				"すべての光景がどうしてもまぼろしのごとく感ずる。" },
    	    { "ページ３","　予はふかくこの夢幻の感じに酔うて、河口湖畔の舟津（ふなづ）へいでた。" +
    	    		"舟津の家なみや人のゆききや、馬のゆくのも子どもの遊ぶのも、" +
    	    		"また湖水の深沈（しんちん）としずかなありさまやが、ことごとく夢中の光景としか思えない。" +
    	    		"\n　家なみから北のすみがすこしく湖水へはりだした木立ちのなかに、" +
    	    		"古い寺と古い神社とが地つづきに立っている。" +
    	    		"木立ちはいまさかんに黄葉（こうよう）しているが、落ち葉も庭をうずめている。" +
    	    		"右手な神社のまた右手の一角にまっ黒い大石が乱立して湖水へつきいで、" +
    	    		"そのうえにちょっとした宿屋がある。まえはわずかに人の通（かよ）うばかりにせまい。" +
    	    		"そこに着物などほしかけて女がひとり洗濯をやっていた。これが予のいまおる宿である。" +
    	    		"そして予はいま上代的紅顔（じょうだいてきこうがん）の美女に中食をすすめられつついる。" +
    	    		"予はさきに宿の娘といったが、このことばをふつうにいう宿屋の娘の軽薄な意味にとられてはこまる。"},
    	    { "ページ４","　予の口がおもいせいか、娘はますますかたい。予はことばをおしだすようにして、" +
    	    		"夏になればずいぶん東京あたりから人がきますか、" +
    	    		"夏は涼しいでしょう。鵜島には紅葉がありますか。" +
    	    		"鵜島まではなん里くらいありますなど話しかけてみたが、娘はただ、ハイハイというばかり、" +
    	    		"声を聞きながら形は見えないような心持ちだ。段ばしごの下から、" +
    	    		"「舟がきてるからお客さまに申しあげておくれ」" +
    	    		"というのは、主人らしい人の声である。飯（めし）がすむ。娘はさがる。" +
    	    		"\n　鵜島は、湖水の沖のちょうどまんなかごろにある離れ小島との話で、" +
    	    		"なんだかひじょうに遠いところででもあるように思われる。" +
    	    		"いまからでかけてきょうじゅうに帰ってこられるかしらなどと考える。" +
    	    		"外のようすは霧がおりてぼんやりとしてきた。娘はふたたびあがってきて、" +
    	    		"舟子（かこ）が待っておりますでございますと例のとおりていねいに両手をついていう。"},
    	    };

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

    		List<String> alist = new ArrayList<String>();
    		for (String[] pagelist : PAGELIST) {
    			/* 久家 TODO PAGELISTを１つずつ配列に追加
    			alist.add(pagelist[0]);
    			*/
    		}

			/* 久家 TODO リストをActivityに設定
            setListAdapter(new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_activated_1, alist));
    		*/

        	// ２画面表示かどうかを判定している
            View detailsFrame = getActivity().findViewById(R.id.details);
            										// getVisibility()は可視状態を返す
            mTwoPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        }
         @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
			String contents = PAGELIST[position][1];
            showDetails(contents);
    	}


        void showDetails(String contents) {

        	// ２画面表示かどうかで処理が別れる
            if (mTwoPane) {
        			// リフレクションを使ってインスタンスを生成するにはClass#newInstance()を使う。
                    DetailsActivity.DetailsFragment fragment=
                            DetailsActivity.DetailsFragment.newInstance(contents);
        			/* 久家 TODO 新しいフラグメントを生成してフラグメントマネージャーに上書き
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.details,fragment);

                    ft.commit();
        			 */
            } else {
    			/* TODO 久家 １画面表示の場合、DetailsActivityを次のActivityとして呼び出す
            	// Activityの起動
                Intent intent = new Intent();
                intent.setClass(getActivity(), DetailsActivity.class);

            	intent.putExtra("contents",contents);
                startActivity(intent);
        		 */
            }
        }
    }

}
