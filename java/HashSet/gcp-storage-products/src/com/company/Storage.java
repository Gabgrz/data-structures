package com.company;

import java.util.Set;
import java.util.HashSet;

import java.util.Objects;

public class Storage {

    private long id;
    private String name;

    public Storage(long id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage storage = (Storage) o;
        return id == storage.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Storage{id=" +
                this.id +
                "," +
                "name="+
                this.name +
                "}";
    }

    public static void main(String[] args) {
        Set<Storage> gcpStorage = new HashSet<>();
        gcpStorage.add(new Storage(1000,"Cloud SQL"));
        gcpStorage.add(new Storage(1001,"Cloud Storage"));
        gcpStorage.add(new Storage(1002,"Datastore"));
        gcpStorage.add(new Storage(1003,"Bigtable"));
        gcpStorage.add(new Storage(1004,"Cloud Memorystore"));
        gcpStorage.add(new Storage(1005,"Cloud Spanner"));
        gcpStorage.add(new Storage(1006,"Firestore"));
        gcpStorage.add(new Storage(1007,"Firebase Real Time Database"));

        System.out.println(gcpStorage);

        // HashSet will use hashCode() and equals() to evaluate duplicates and ignore them.
        gcpStorage.add(new Storage(1006,"Firestore"));
        System.out.println(gcpStorage);

    }
}
