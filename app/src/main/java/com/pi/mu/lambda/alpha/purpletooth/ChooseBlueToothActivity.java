package com.pi.mu.lambda.alpha.purpletooth;

import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.pi.mu.lambda.alpha.purpletooth.clientItem.ClientContent;


public class ChooseBlueToothActivity extends AppCompatActivity
    implements ClientsFragment.OnFragmentInteractionListener {

    private BluetoothAdapter BTadapter = BluetoothAdapter.getDefaultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_blue_tooth);

        BTadapter.startDiscovery();
        registerReceiver(receiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_blue_tooth, menu);
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

    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)) {
                String uuid = intent.getStringExtra(BluetoothDevice.ACTION_UUID);
                int rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI,Short.MIN_VALUE);
                String name = intent.getStringExtra(BluetoothDevice.EXTRA_NAME);

                Log.d("Find bluetooth", "" + uuid + " " + rssi + " " + name);

                ClientContent.ITEMS.add(new ClientContent.ClientItem(uuid, name, "" + rssi + "dBm"));
                ClientsFragment f = (ClientsFragment)getFragmentManager()
                        .findFragmentById(R.id.fragmentList);

                f.refreshList();

            }
        }
    };

    public void refreshButtonHandler(View view) {
        BTadapter.startDiscovery();
        ClientContent.ITEMS.clear();
        ClientsFragment f = (ClientsFragment)getFragmentManager()
                .findFragmentById(R.id.fragmentList);

        f.refreshList();
    }

    public void onFragmentInteraction(String s) {
        Intent intent = new Intent();
        intent.putExtra("result", s);
        setResult(RESULT_OK,intent);
        finish();
    }

}
