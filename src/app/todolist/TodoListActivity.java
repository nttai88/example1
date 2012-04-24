package app.todolist;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class TodoListActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView listView = (ListView) findViewById(R.id.myListView);
		final EditText editText = (EditText) findViewById(R.id.myEditText);
		final ArrayList<String> todoItems = new ArrayList<String>();
		final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
		listView.setAdapter(arrayAdapter);
		editText.setOnKeyListener(new View.OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN)
					if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
						EditText edittxt = (EditText)v;
						todoItems.add(0, edittxt.getText().toString());
						arrayAdapter.notifyDataSetChanged();
						edittxt.setText("");
						return true;
					}
				return false;
			}
		});
	}
}
