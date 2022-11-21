import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneBook {

    protected Map<String, List<Contact>> groupsMap = new HashMap<>();
    protected ArrayList<Contact> arrayList = new ArrayList<>();

    protected void addGroup(String inputGroup) {
        if (!groupsMap.containsKey(inputGroup)) {
            groupsMap.put(inputGroup, new ArrayList<>());
            System.out.println("Группа " + inputGroup + " добавлена");
        } else {
            System.out.println("Такая группа есть!");
        }
    }

    protected void deleteGroup(String nameGroup) {
        groupsMap.remove(nameGroup);
        System.out.format("Группа \"%s\" удалена!\n", nameGroup);
    }

    protected Contact createContact(long number, String name) {
        return new Contact(number, name);
    }

    protected void addContact(String inputGroup, String name) {
        List<Contact> contactList;
        if (groupsMap.containsKey(inputGroup)) {
            contactList = groupsMap.get(inputGroup);
            for (Contact contact : arrayList) {
                if (contact.name.equals(name) && !contactList.contains(contact)) {
                    contactList.add(contact);
                    groupsMap.put(inputGroup, contactList);
                    System.out.format("Контакт %s добавлен в группу %s\n", contactList.get(contactList.size() - 1), inputGroup);
                    return;
                }
            }
        }
        if (!groupsMap.containsKey(inputGroup)) {
            System.out.format("Такой группы нет! контакт \"%s\" не добавлен\n", name);
        } else {
            System.out.format("Такого контакта (%s) нет\n", name);
        }
    }

    protected void deleteContact(String name) {
        for (String group : groupsMap.keySet()) {
            List<Contact> contactList = groupsMap.get(group);
            for (Contact contact : contactList) {
                if (contact.name.equals(name)) {
                    contactList.remove(contact);
                    System.out.format("Контакт удалён %s\n", contact);
                    return;
                }
            }
        }
        System.out.println("контакт " + name + " не обнаружен");
    }

    protected List<Contact> findContactInGroup(String inputGroup) {
        return groupsMap.getOrDefault(inputGroup, null);
    }

    protected Contact searchByNumber(long number) {
        for (String group : groupsMap.keySet()) {
            List<Contact> contactList = groupsMap.get(group);
            for (Contact contact : contactList) {
                if (contact.phoneNumber == number) {
                    return contact;
                }
            }
        }
        return null;
    }
}

