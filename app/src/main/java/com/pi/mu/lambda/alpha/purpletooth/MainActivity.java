package com.pi.mu.lambda.alpha.purpletooth;

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

import com.pi.mu.lambda.alpha.purpletooth.connectedClientItem.ConnectedClientContent;


public class MainActivity extends AppCompatActivity
        implements ConnectedClientFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    public void FloatButtonHandler(View view) {
        Intent intent = new Intent(this, ChooseBlueToothActivity.class);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("result:", "" + requestCode + " " +  resultCode);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String result=data.getStringExtra("result");
                ConnectedClientContent.ITEMS.add(
                        new ConnectedClientContent.ConnectedClientItem(
                                result, "Near by.."
                        )
                );
                Log.d("count: ", "" + ConnectedClientContent.ITEMS.size());
                ConnectedClientFragment f = (ConnectedClientFragment)getFragmentManager()
                        .findFragmentById(R.id.fragmentList);

                f.refreshList();
            }
            if (resultCode == RESULT_CANCELED) {

            }
        }
    }

    public void onFragmentInteraction(String s) {

    }
}
