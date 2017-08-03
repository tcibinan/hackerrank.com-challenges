package contacts;

import java.io.*;
import java.util.*;

public class Solution {

    static Contacts contacts = new TreeContacts();

    public static void main(String[] args) {
        Scanner in = new Scanner(new StringReader(String.join(" ", args)));
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            perform(op, contact);
        }
    }

    public static void perform(String op, String contact) {
        if (op.equals("add")) {
            contacts.addContact(contact);
        } else if (op.equals("find")) {
            System.out.println(contacts.findContacts(contact));
        }
    }

    interface Contacts {
        void addContact(String contact);
        int findContacts(String contact);
    }

    static class SetContacts implements Contacts {

        private Set<String> set = new HashSet<>();

        public void addContact(String contact) {
            set.add(contact);
        }

        public int findContacts(String contact) {
            int res = 0;

            Iterator<String> iter = set.iterator();
            while (iter.hasNext()) {
                if (iter.next().startsWith(contact)) {
                    res++;
                }
            }

            return res;
        }
    }

    static class TreeContacts implements Contacts {

        private Node root = new Node(false);

        public void addContact(String contact) {
            addContact(contact, root);
        }

        boolean addContact(String contact, Node root) {
            boolean isNew = false;
            if (!contact.isEmpty()) {
                Node node = root.letters[indexOf(contact.charAt(0))];
                if (node == null) {
                    node = new Node(false);
                    root.letters[indexOf(contact.charAt(0))] = node;
                    isNew = true;
                }
                if (contact.length() == 1) {
                    node.end = true;
                    node.count++;
                } else {
                    isNew = addContact(contact.substring(1), node);
                }
            }
            if (isNew) {
                root.count++;
            }
            return isNew;
        }

        public int findContacts(String contact) {
            return findContacts(contact, root);
        }

        private int findContacts(String contact, Node root) {
            if (!contact.isEmpty()) {
                Node node = root.letters[indexOf(contact.charAt(0))];
                if (node == null) {
                    return 0;
                }
                return contact.length() == 1
                        ? node.count
                        : findContacts(contact.substring(1), node);
            } else {
                return root.count;
            }
        }

        private static int indexOf(char c) {
            return c - 'a';
        }

        private static class Node {
            boolean end;
            int count;
            Node[] letters = new Node[26];

            public Node(boolean end) {
                this.end = end;
            }
        }
    }

}
