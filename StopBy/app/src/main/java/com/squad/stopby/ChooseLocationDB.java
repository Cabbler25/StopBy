package com.squad.stopby;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class ChooseLocationDB {

        private String name;
        private String message;

        public ChooseLocationDB(){
            this.name = null;
            this.message = null;
        }


        public ChooseLocationDB(String name, String msg){
            this.name = name;
            this.message = msg;
        }

        public void setUsername(String name){
            this.name = name;
        }

        public void setPost(String post) {
            this.message = post;
        }

        public String getUsername() {
            return name;
        }

        public String getMessage() {
            return message;
        }

        public void pushToLocation(DatabaseReference databaseReference, String chosenLocation){
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
            final String location = "location";
            final String current = chosenLocation;
            databaseReference.child(location).child(current).child(currentUser.getUid()).setValue(this);
        }
    }

