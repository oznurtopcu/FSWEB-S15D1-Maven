package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = contacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if(!myContacts.contains(contact)) {
            myContacts.add(contact);
        }

        return myContacts.contains(contact);
    }

    public boolean updateContact(Contact contact1, Contact contact2) {
        if(myContacts.contains(contact1)) {
            removeContact(contact1);
            addNewContact(contact2);
            return true;
        }else {
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        if(myContacts.contains(contact)) {
            myContacts.remove(contact);
        }

        return !myContacts.contains(contact);
    }

    public int findContact(Contact contact) {
//        if(myContacts.contains(contact)) {
//            return myContacts.indexOf(contact);
//        }else {
//            return -1;
//        }

        for(Contact contact1: myContacts) {
            if(contact.equals(contact1)) {
                return myContacts.indexOf(contact1);
            }
        }
        return -1;
    }

    public int findContact(String contact) {

        for(Contact contact1: myContacts) {
            if(contact.equals(contact1.getName())) {
                return myContacts.indexOf(contact1);
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName) {
        for(Contact contact1: myContacts) {
            if(contactName.equals(contact1.getName())) {
                return contact1;
            }
        }
        return null;
    }

    public void printContact() {
        for (int i=0;i<myContacts.size();i++) {
            System.out.println(i+1 + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }



}
