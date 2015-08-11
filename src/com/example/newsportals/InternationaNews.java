package com.example.newsportals;

import java.util.ArrayList;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;

import com.ramananda.bean.Category;
import com.ramananda.bean.InternationNewsAdapter;

public class InternationaNews extends Activity {
	private ListView inListView;

	InternationNewsAdapter adapter;
	private String[] inNewsTitle;

	ArrayList<Category> inNewsList;

	private String[] inUrl;
	private String[] inState;
	String Go_url = "url_link";
	String Title = "news_title";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.internationa_news_activity);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		inListView = (ListView) findViewById(R.id.internation_listview);
		inNewsTitle = getResources().getStringArray(
				R.array.international_news_title);

		inState = getResources().getStringArray(R.array.international_state);

		inNewsList = new ArrayList<Category>();

		for (int i = 0; i < inNewsTitle.length && i < inState.length; i++) {
			Category ins = new Category(inNewsTitle[i], inState[i]);
			inNewsList.add(ins);
		}

		adapter = new InternationNewsAdapter(getApplicationContext(),
				inNewsList);
		inListView.setAdapter(adapter);
		inListView.setTextFilterEnabled(true);

		inUrl = getResources().getStringArray(R.array.international_news_url);

		// set search option

		inListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int positon,
					long id) {
				String selected = ((TextView) v
						.findViewById(R.id.internation_news_title)).getText()
						.toString();

				// Toast.makeText(getApplicationContext(),
				// "you selected " + selected, Toast.LENGTH_LONG).show();
				//

				setURl(selected);
			}
		});
	}

	private void setURl(String str) {
		Intent intent = new Intent(InternationaNews.this,
				CommonWebViewActivity.class);

		if (str.equals("The New York Times")) {
			intent.putExtra(Go_url, inUrl[0]);
			intent.putExtra(Title, inNewsTitle[0]);
		} else if (str.equals("The Washington Post")) {
			intent.putExtra(Go_url, inUrl[1]);
			intent.putExtra(Title, inNewsTitle[1]);
		} else if (str.equals("The Wall Street Journal")) {
			intent.putExtra(Go_url, inUrl[2]);
			intent.putExtra(Title, inNewsTitle[2]);
		} else if (str.equals("USA Today")) {
			intent.putExtra(Go_url, inUrl[3]);
			intent.putExtra(Title, inNewsTitle[3]);
		} else if (str.equals("Los Angeles Times")) {
			intent.putExtra(Go_url, inUrl[4]);
			intent.putExtra(Title, inNewsTitle[4]);
		} else if (str.equals("The Examiner")) {
			intent.putExtra(Go_url, inUrl[5]);
			intent.putExtra(Title, inNewsTitle[5]);
		} else if (str.equals("Daily News")) {
			intent.putExtra(Go_url, inUrl[6]);
			intent.putExtra(Title, inNewsTitle[6]);
		} else if (str.equals("Chicago Tribune")) {
			intent.putExtra(Go_url, inUrl[7]);
			intent.putExtra(Title, inNewsTitle[7]);
		} else if (str.equals("Houston Chroncle")) {
			intent.putExtra(Go_url, inUrl[8]);
			intent.putExtra(Title, inNewsTitle[8]);
		} else if (str.equals("New York Post")) {
			intent.putExtra(Go_url, inUrl[9]);
			intent.putExtra(Title, inNewsTitle[9]);
		} else if (str.equals("The Christian Science Montor")) {
			intent.putExtra(Go_url, inUrl[10]);
			intent.putExtra(Title, inNewsTitle[10]);
		} else if (str.equals("The Hollywood Reporter")) {
			intent.putExtra(Go_url, inUrl[11]);
			intent.putExtra(Title, inNewsTitle[11]);
		} else if (str.equals("The Chicago Sun-Times")) {
			intent.putExtra(Go_url, inUrl[12]);
			intent.putExtra(Title, inNewsTitle[12]);
		} else if (str.equals("The Washinton Times")) {
			intent.putExtra(Go_url, inUrl[13]);
			intent.putExtra(Title, inNewsTitle[13]);
		} else if (str.equals("The Pladelphia Inquirer")) {
			intent.putExtra(Go_url, inUrl[14]);
			intent.putExtra(Title, inNewsTitle[14]);
		} else if (str.equals("San Jose Mercury News")) {
			intent.putExtra(Go_url, inUrl[15]);
			intent.putExtra(Title, inNewsTitle[15]);
		} else if (str.equals("The Onion")) {
			intent.putExtra(Go_url, inUrl[16]);
			intent.putExtra(Title, inNewsTitle[16]);
		} else if (str.equals("The Denver Post")) {
			intent.putExtra(Go_url, inUrl[17]);
			intent.putExtra(Title, inNewsTitle[17]);
		} else if (str.equals("Newsday")) {
			intent.putExtra(Go_url, inUrl[18]);
			intent.putExtra(Title, inNewsTitle[18]);
		} else if (str.equals("The Sacramento Bee")) {
			intent.putExtra(Go_url, inUrl[19]);
			intent.putExtra(Title, inNewsTitle[19]);

		} else if (str.equals("Star Tribune")) {
			intent.putExtra(Go_url, inUrl[20]);
			intent.putExtra(Title, inNewsTitle[20]);
		} else if (str.equals("The Miami Herald")) {
			intent.putExtra(Go_url, inUrl[21]);
			intent.putExtra(Title, inNewsTitle[21]);
		} else if (str.equals("The Dallas Mornng News")) {
			intent.putExtra(Go_url, inUrl[22]);
			intent.putExtra(Title, inNewsTitle[22]);
		} else if (str.equals("The Boston Globe")) {
			intent.putExtra(Go_url, inUrl[23]);
			intent.putExtra(Title, inNewsTitle[23]);
		} else if (str.equals("The Oregonian")) {
			intent.putExtra(Go_url, inUrl[24]);
			intent.putExtra(Title, inNewsTitle[24]);
		} else if (str.equals("The Baltimore Sun")) {
			intent.putExtra(Go_url, inUrl[25]);
			intent.putExtra(Title, inNewsTitle[25]);
		} else if (str.equals("The Seattle Times")) {
			intent.putExtra(Go_url, inUrl[26]);
			intent.putExtra(Title, inNewsTitle[26]);
		} else if (str.equals("The Atlanta Journal-Constitution")) {
			intent.putExtra(Go_url, inUrl[27]);
			intent.putExtra(Title, inNewsTitle[27]);
		} else if (str.equals("Boston Herald")) {
			intent.putExtra(Go_url, inUrl[28]);
			intent.putExtra(Title, inNewsTitle[28]);
		} else if (str.equals("The Plain Dealer")) {
			intent.putExtra(Go_url, inUrl[29]);
			intent.putExtra(Title, inNewsTitle[29]);
		}

		else if (str.equals("Detroit Free Press")) {
			intent.putExtra(Go_url, inUrl[30]);
			intent.putExtra(Title, inNewsTitle[30]);

		} else if (str.equals("Seattle Post-Intelligencer")) {
			intent.putExtra(Go_url, inUrl[31]);
			intent.putExtra(Title, inNewsTitle[31]);
		} else if (str.equals("Orlando Sentinel")) {
			intent.putExtra(Go_url, inUrl[32]);
			intent.putExtra(Title, inNewsTitle[32]);
		} else if (str.equals("South Florida Sun-Sentinel")) {
			intent.putExtra(Go_url, inUrl[33]);
			intent.putExtra(Title, inNewsTitle[33]);
		} else if (str.equals("The Hill")) {
			intent.putExtra(Go_url, inUrl[34]);
			intent.putExtra(Title, inNewsTitle[34]);
		} else if (str.equals("Pittsburgh Post-Gazette")) {
			intent.putExtra(Go_url, inUrl[35]);
			intent.putExtra(Title, inNewsTitle[35]);
		} else if (str.equals("Milwaukee Journal Sentinel")) {
			intent.putExtra(Go_url, inUrl[36]);
			intent.putExtra(Title, inNewsTitle[36]);
		} else if (str.equals("The Kansas City Star")) {
			intent.putExtra(Go_url, inUrl[37]);
			intent.putExtra(Title, inNewsTitle[37]);
		} else if (str.equals("The New York Observer")) {
			intent.putExtra(Go_url, inUrl[38]);
			intent.putExtra(Title, inNewsTitle[38]);
		} else if (str.equals("St. Louis Post-Dispatch")) {
			intent.putExtra(Go_url, inUrl[39]);
			intent.putExtra(Title, inNewsTitle[39]);
		}

		else if (str.equals("The Orange County Register")) {
			intent.putExtra(Go_url, inUrl[40]);
			intent.putExtra(Title, inNewsTitle[40]);
		} else if (str.equals("The Columbus Dispatch")) {
			intent.putExtra(Go_url, inUrl[41]);
			intent.putExtra(Title, inNewsTitle[41]);
		} else if (str.equals("Hartford Courant")) {
			intent.putExtra(Go_url, inUrl[42]);
			intent.putExtra(Title, inNewsTitle[42]);
		} else if (str.equals("Express-News")) {
			intent.putExtra(Go_url, inUrl[43]);
			intent.putExtra(Title, inNewsTitle[43]);
		} else if (str.equals("The News and Observer")) {
			intent.putExtra(Go_url, inUrl[44]);
			intent.putExtra(Title, inNewsTitle[44]);
		} else if (str.equals("Deseret News")) {
			intent.putExtra(Go_url, inUrl[45]);
			intent.putExtra(Title, inNewsTitle[45]);
		} else if (str.equals("Salt Lake Tribune")) {
			intent.putExtra(Go_url, inUrl[46]);
			intent.putExtra(Title, inNewsTitle[46]);
		} else if (str.equals("Investor's Business Daily")) {
			intent.putExtra(Go_url, inUrl[47]);
			intent.putExtra(Title, inNewsTitle[47]);
		} else if (str.equals("Times Union")) {
			intent.putExtra(Go_url, inUrl[48]);
			intent.putExtra(Title, inNewsTitle[48]);
		} else if (str.equals("Arizona Daily Star")) {
			intent.putExtra(Go_url, inUrl[49]);
			intent.putExtra(Title, inNewsTitle[49]);
		}

		else if (str.equals("The Guardian")) {
			intent.putExtra(Go_url, inUrl[50]);
			intent.putExtra(Title, inNewsTitle[50]);
		} else if (str.equals("The Daily Mail")) {
			intent.putExtra(Go_url, inUrl[51]);
			intent.putExtra(Title, inNewsTitle[51]);
		} else if (str.equals("The Daily Telegraph")) {
			intent.putExtra(Go_url, inUrl[52]);
			intent.putExtra(Title, inNewsTitle[52]);
		} else if (str.equals("The Independent")) {
			intent.putExtra(Go_url, inUrl[53]);
			intent.putExtra(Title, inNewsTitle[53]);
		} else if (str.equals("Financial Times")) {
			intent.putExtra(Go_url, inUrl[54]);
			intent.putExtra(Title, inNewsTitle[54]);
		} else if (str.equals("Daily Mirror")) {
			intent.putExtra(Go_url, inUrl[55]);
			intent.putExtra(Title, inNewsTitle[55]);
		} else if (str.equals("The Sun")) {
			intent.putExtra(Go_url, inUrl[56]);
			intent.putExtra(Title, inNewsTitle[56]);
		} else if (str.equals("Daily Express")) {
			intent.putExtra(Go_url, inUrl[57]);
			intent.putExtra(Title, inNewsTitle[57]);
		} else if (str.equals("The Times")) {
			intent.putExtra(Go_url, inUrl[58]);
			intent.putExtra(Title, inNewsTitle[58]);
		} else if (str.equals("Evening Standard")) {
			intent.putExtra(Go_url, inUrl[59]);
			intent.putExtra(Title, inNewsTitle[59]);
		}

		else if (str.equals("Bild")) {
			intent.putExtra(Go_url, inUrl[60]);
			intent.putExtra(Title, inNewsTitle[60]);
		} else if (str.equals("Die Welt")) {
			intent.putExtra(Go_url, inUrl[61]);
			intent.putExtra(Title, inNewsTitle[61]);
		} else if (str.equals("Suddeutsche Zeitung")) {
			intent.putExtra(Go_url, inUrl[62]);
			intent.putExtra(Title, inNewsTitle[62]);
		} else if (str.equals("Die Zeit")) {
			intent.putExtra(Go_url, inUrl[63]);
			intent.putExtra(Title, inNewsTitle[63]);
		} else if (str.equals("Handelsblatt")) {
			intent.putExtra(Go_url, inUrl[64]);
			intent.putExtra(Title, inNewsTitle[64]);
		} else if (str.equals("Rheinische Post")) {
			intent.putExtra(Go_url, inUrl[65]);
			intent.putExtra(Title, inNewsTitle[65]);
		} else if (str.equals("Die Tageszeitung")) {
			intent.putExtra(Go_url, inUrl[66]);
			intent.putExtra(Title, inNewsTitle[66]);
		} else if (str.equals("Hamburger Abendblatt")) {
			intent.putExtra(Go_url, inUrl[67]);
			intent.putExtra(Title, inNewsTitle[67]);
		} else if (str.equals("The Times of India")) {
			intent.putExtra(Go_url, inUrl[68]);
			intent.putExtra(Title, inNewsTitle[68]);
		} else if (str.equals("The Hindu")) {
			intent.putExtra(Go_url, inUrl[69]);
			intent.putExtra(Title, inNewsTitle[69]);
		}

		else if (str.equals("The Hindustan Times")) {
			intent.putExtra(Go_url, inUrl[70]);
			intent.putExtra(Title, inNewsTitle[70]);
		} else if (str.equals("Dainik Bhaskar")) {
			intent.putExtra(Go_url, inUrl[71]);
			intent.putExtra(Title, inNewsTitle[71]);
		} else if (str.equals("The People's Daily")) {
			intent.putExtra(Go_url, inUrl[72]);
			intent.putExtra(Title, inNewsTitle[72]);
		} else if (str.equals("Qingdao News")) {
			intent.putExtra(Go_url, inUrl[73]);
			intent.putExtra(Title, inNewsTitle[73]);
		} else if (str.equals("Yangtse Evening Post")) {
			intent.putExtra(Go_url, inUrl[74]);
			intent.putExtra(Title, inNewsTitle[74]);
		} else if (str.equals("La Repubblica")) {
			intent.putExtra(Go_url, inUrl[75]);
			intent.putExtra(Title, inNewsTitle[75]);
		} else if (str.equals("Corriere della Sera")) {
			intent.putExtra(Go_url, inUrl[76]);
			intent.putExtra(Title, inNewsTitle[76]);
		} else if (str.equals("II Sole24 Ore")) {
			intent.putExtra(Go_url, inUrl[77]);
			intent.putExtra(Title, inNewsTitle[77]);
		} else if (str.equals("La Gazzetta dello Sport")) {
			intent.putExtra(Go_url, inUrl[78]);
			intent.putExtra(Title, inNewsTitle[78]);
		} else if (str.equals("La Stampa")) {
			intent.putExtra(Go_url, inUrl[79]);
			intent.putExtra(Title, inNewsTitle[79]);
		}

		else if (str.equals("El Pais")) {
			intent.putExtra(Go_url, inUrl[80]);
			intent.putExtra(Title, inNewsTitle[80]);
		} else if (str.equals("ABC")) {
			intent.putExtra(Go_url, inUrl[81]);
			intent.putExtra(Title, inNewsTitle[81]);
		} else if (str.equals("AS")) {
			intent.putExtra(Go_url, inUrl[82]);
			intent.putExtra(Title, inNewsTitle[82]);
		} else if (str.equals("El Economista")) {
			intent.putExtra(Go_url, inUrl[83]);
			intent.putExtra(Title, inNewsTitle[83]);
		} else if (str.equals("La Vanguardia")) {
			intent.putExtra(Go_url, inUrl[84]);
			intent.putExtra(Title, inNewsTitle[84]);
		} else if (str.equals("Le Monde")) {
			intent.putExtra(Go_url, inUrl[85]);
			intent.putExtra(Title, inNewsTitle[85]);
		} else if (str.equals("Liberation")) {
			intent.putExtra(Go_url, inUrl[86]);
			intent.putExtra(Title, inNewsTitle[86]);
		} else if (str.equals("Le Nouvel Observateur")) {
			intent.putExtra(Go_url, inUrl[87]);
			intent.putExtra(Title, inNewsTitle[87]);
		} else if (str.equals("L'Equipe")) {
			intent.putExtra(Go_url, inUrl[88]);
			intent.putExtra(Title, inNewsTitle[88]);
		} else if (str.equals("Les Echos")) {
			intent.putExtra(Go_url, inUrl[89]);
			intent.putExtra(Title, inNewsTitle[89]);
		}

		else if (str.equals("Milliyet")) {
			intent.putExtra(Go_url, inUrl[90]);
			intent.putExtra(Title, inNewsTitle[90]);
		} else if (str.equals("Sabah")) {
			intent.putExtra(Go_url, inUrl[91]);
			intent.putExtra(Title, inNewsTitle[91]);
		} else if (str.equals("Zaman")) {
			intent.putExtra(Go_url, inUrl[92]);
			intent.putExtra(Title, inNewsTitle[92]);
		} else if (str.equals("Asahi Shimbun")) {
			intent.putExtra(Go_url, inUrl[93]);
			intent.putExtra(Title, inNewsTitle[93]);
		} else if (str.equals("Yomiuri Shimbun")) {
			intent.putExtra(Go_url, inUrl[94]);
			intent.putExtra(Title, inNewsTitle[94]);
		} else if (str.equals("Nihon Keizai Shimbun")) {
			intent.putExtra(Go_url, inUrl[95]);
			intent.putExtra(Title, inNewsTitle[95]);
		} else if (str.equals("The Japan Times")) {
			intent.putExtra(Go_url, inUrl[96]);
			intent.putExtra(Title, inNewsTitle[96]);
		} else if (str.equals("Mainichi Shimbun")) {
			intent.putExtra(Go_url, inUrl[97]);
			intent.putExtra(Title, inNewsTitle[97]);
		} else if (str.equals("Nikkan Sports")) {
			intent.putExtra(Go_url, inUrl[98]);
			intent.putExtra(Title, inNewsTitle[98]);
		} else if (str.equals("Sankei Sports")) {
			intent.putExtra(Go_url, inUrl[99]);
			intent.putExtra(Title, inNewsTitle[99]);
		}

		else if (str.equals("The Age")) {
			intent.putExtra(Go_url, inUrl[100]);
			intent.putExtra(Title, inNewsTitle[100]);
		} else if (str.equals("Herald Sun")) {
			intent.putExtra(Go_url, inUrl[101]);
			intent.putExtra(Title, inNewsTitle[101]);
		} else if (str.equals("The Advertiser")) {
			intent.putExtra(Go_url, inUrl[102]);
			intent.putExtra(Title, inNewsTitle[102]);
		} else if (str.equals("Kommersant")) {
			intent.putExtra(Go_url, inUrl[103]);
			intent.putExtra(Title, inNewsTitle[103]);
		} else if (str.equals("Rossiyskaya Gazeta")) {
			intent.putExtra(Go_url, inUrl[104]);
			intent.putExtra(Title, inNewsTitle[104]);
		} else if (str.equals("Charin")) {
			intent.putExtra(Go_url, inUrl[105]);
			intent.putExtra(Title, inNewsTitle[105]);
		} else if (str.equals("La Nacion")) {
			intent.putExtra(Go_url, inUrl[106]);
			intent.putExtra(Title, inNewsTitle[106]);
		} else if (str.equals("Pagina/12")) {
			intent.putExtra(Go_url, inUrl[107]);
			intent.putExtra(Title, inNewsTitle[107]);
		} else if (str.equals("Aftonbladet")) {
			intent.putExtra(Go_url, inUrl[108]);
			intent.putExtra(Title, inNewsTitle[108]);
		} else if (str.equals("Dagens Nyheter")) {
			intent.putExtra(Go_url, inUrl[109]);
			intent.putExtra(Title, inNewsTitle[109]);
		}
		// completed here
		else if (str.equals("The Jerusalem Post")) {
			intent.putExtra(Go_url, inUrl[110]);
			intent.putExtra(Title, inNewsTitle[110]);
		} else if (str.equals("Haaretz")) {
			intent.putExtra(Go_url, inUrl[111]);
			intent.putExtra(Title, inNewsTitle[111]);
		} else if (str.equals("Yediot Aharonot")) {
			intent.putExtra(Go_url, inUrl[112]);
			intent.putExtra(Title, inNewsTitle[112]);
		} else if (str.equals("Dagbladet")) {
			intent.putExtra(Go_url, inUrl[113]);
			intent.putExtra(Title, inNewsTitle[113]);
		} else if (str.equals("Verdens Gang")) {
			intent.putExtra(Go_url, inUrl[114]);
			intent.putExtra(Title, inNewsTitle[114]);
		} else if (str.equals("Aftenposten")) {
			intent.putExtra(Go_url, inUrl[115]);
			intent.putExtra(Title, inNewsTitle[115]);
		} else if (str.equals("The Globe and Mail")) {
			intent.putExtra(Go_url, inUrl[116]);
			intent.putExtra(Title, inNewsTitle[116]);
		} else if (str.equals("The Toronto Star")) {
			intent.putExtra(Go_url, inUrl[117]);
			intent.putExtra(Title, inNewsTitle[117]);
		} else if (str.equals("The Vancouver Sun")) {
			intent.putExtra(Go_url, inUrl[118]);
			intent.putExtra(Title, inNewsTitle[118]);
		} else if (str.equals("Toronto Sun")) {
			intent.putExtra(Go_url, inUrl[119]);
			intent.putExtra(Title, inNewsTitle[119]);
		}

		else if (str.equals("Algemeen Dagblad")) {
			intent.putExtra(Go_url, inUrl[120]);
			intent.putExtra(Title, inNewsTitle[120]);
		} else if (str.equals("NRC Handelsblad")) {
			intent.putExtra(Go_url, inUrl[121]);
			intent.putExtra(Title, inNewsTitle[121]);
		} else if (str.equals("United Daily News")) {
			intent.putExtra(Go_url, inUrl[122]);
			intent.putExtra(Title, inNewsTitle[122]);
		} else if (str.equals("China Times")) {
			intent.putExtra(Go_url, inUrl[123]);
			intent.putExtra(Title, inNewsTitle[123]);
		} else if (str.equals("Arab News")) {
			intent.putExtra(Go_url, inUrl[124]);
			intent.putExtra(Title, inNewsTitle[124]);
		} else if (str.equals("Asharq Al-Awsat")) {
			intent.putExtra(Go_url, inUrl[125]);
			intent.putExtra(Title, inNewsTitle[125]);
		} else if (str.equals("Gazeta Wyborcza")) {
			intent.putExtra(Go_url, inUrl[126]);
			intent.putExtra(Title, inNewsTitle[126]);
		} else if (str.equals("Mlada fronta Dnes")) {
			intent.putExtra(Go_url, inUrl[127]);
			intent.putExtra(Title, inNewsTitle[127]);
		} else if (str.equals("O Globo")) {
			intent.putExtra(Go_url, inUrl[128]);
			intent.putExtra(Title, inNewsTitle[128]);
			intent.putExtra(Title, inNewsTitle[128]);
		} else if (str.equals("The New Zealand Herald")) {
			intent.putExtra(Go_url, inUrl[129]);
			intent.putExtra(Title, inNewsTitle[129]);
		}

		else if (str.equals("Al-Ahram")) {
			intent.putExtra(Go_url, inUrl[130]);
			intent.putExtra(Title, inNewsTitle[130]);
		} else if (str.equals("Philippine Daily Inquirer")) {
			intent.putExtra(Go_url, inUrl[131]);
			intent.putExtra(Title, inNewsTitle[131]);
		} else if (str.equals("The Star Online")) {
			intent.putExtra(Go_url, inUrl[132]);
			intent.putExtra(Title, inNewsTitle[132]);
		} else if (str.equals("Kompas")) {
			intent.putExtra(Go_url, inUrl[133]);
			intent.putExtra(Title, inNewsTitle[133]);
		} else if (str.equals("Dawn")) {
			intent.putExtra(Go_url, inUrl[134]);
			intent.putExtra(Title, inNewsTitle[134]);
		}

		else if (str.equals("The Irish Independent")) {
			intent.putExtra(Go_url, inUrl[135]);
			intent.putExtra(Title, inNewsTitle[135]);
		} else if (str.equals("Het Nieuwsblad")) {
			intent.putExtra(Go_url, inUrl[136]);
			intent.putExtra(Title, inNewsTitle[136]);
		} else if (str.equals("The Straits Times")) {
			intent.putExtra(Go_url, inUrl[137]);
			intent.putExtra(Title, inNewsTitle[137]);
		} else if (str.equals("Gulf News")) {
			intent.putExtra(Go_url, inUrl[138]);
			intent.putExtra(Title, inNewsTitle[138]);
		} else if (str.equals("Die Presse")) {
			intent.putExtra(Go_url, inUrl[139]);
			intent.putExtra(Title, inNewsTitle[139]);
		} else if (str.equals("o Vima")) {
			intent.putExtra(Go_url, inUrl[140]);
			intent.putExtra(Title, inNewsTitle[140]);
		} else if (str.equals("El Unversal")) {
			intent.putExtra(Go_url, inUrl[141]);
			intent.putExtra(Title, inNewsTitle[141]);
		}
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.internationa_news, menu);

		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
				.getActionView();
		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));
		searchView.setIconifiedByDefault(true);

		SearchView.OnQueryTextListener textListener = new OnQueryTextListener() {

			@Override
			public boolean onQueryTextSubmit(String newText) {
				adapter.getFilter().filter(newText);
				return true;
			}

			@Override
			public boolean onQueryTextChange(String query) {
				adapter.getFilter().filter(query);
				return true;
			}
		};
		searchView.setOnQueryTextListener(textListener);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(this, StartActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
