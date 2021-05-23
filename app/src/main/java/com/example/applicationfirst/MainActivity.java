package com.example.applicationfirst;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Users users = new Users();
        List<String> userList = users.getUserList();
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
        Log.d("SYSTEM INFO: ", "Метод onCreate запущен");

    }
    // UserHolder отвечает за каждый элемент списко по отдельности
    // Именно здесь мы будем наполнчть нашу activity_item контентом
    private class UserHolder extends RecyclerView.ViewHolder{
        TextView itemTextView;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.activity_item,viewGroup,false));
            itemTextView = itemView.findViewById(R.id.itemTextView);
        }
        public void bind(String userName){
            itemTextView.setText(userName);
            Log.d("SYSTEM INFO: ", "Метод bind запущен");
        }
    }
    // UserAdapter нужен для того, чтобы разместить элементы на RecyclerView
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        List<String> userList;
        public UserAdapter(List<String> userList) {
            this.userList = userList;
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            // inflater - наполнитель
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new UserHolder(inflater,viewGroup);
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            String userName = userList.get(position);
            userHolder.bind(userName);
            Log.d("SYSTEM INFO: ", "Метод onBindViewHolder запущен");
        }

        @Override
        public int getItemCount() {
            return userList.size();

        }



    }

}