package at.jugendhackt.soundsnett.soundsnett;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import at.jugendhackt.soundsnett.soundsnett.model.Contact;
import at.jugendhackt.soundsnett.soundsnett.views.ChatActivity;
import at.jugendhackt.soundsnett.soundsnett.views.ContactAdapter;
import at.jugendhackt.soundsnett.soundsnett.views.WebViewActivity;

public class MainActivity extends AppCompatActivity {
    ContactAdapter mAdapter;
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView = findViewById(R.id.recyclerview);
        //mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

         mAdapter = new ContactAdapter();

         mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                mAdapter.clearContacts();
                mAdapter.addContact(new Contact("Yusuf", R.drawable.yusuf));
                mAdapter.addContact(new Contact("Sarah", R.drawable.sarah));
                mAdapter.addContact(new Contact("Leon", R.drawable.leon));
                mAdapter.addContact(new Contact("Taleb", R.drawable.taleb));
                mAdapter.addContact(new Contact("Chris", R.drawable.chris));
                mAdapter.addContact(new Contact("Lisa", R.drawable.lisa));
                MediaPlayer player = MediaPlayer.create(getApplicationContext(),R.raw.ding_dong);
                player.start();
                return true;
            }
        });
        menu.getItem(1).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent i = new Intent(getApplicationContext(), WebViewActivity.class);
                i.putExtra("url","file:///android_asset/index.html");
                getApplicationContext().startActivity(i);
                return true;
            }
        });

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
