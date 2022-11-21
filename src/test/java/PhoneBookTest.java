
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PhoneBookTest {
    Contact contact;
    PhoneBook phoneBook;

    @BeforeEach
    void contact() {
        contact = new Contact(89830002343L, "Pavel");
        phoneBook = new PhoneBook();
    }

    @Test
    public void searchByNumberTest() {
        phoneBook.arrayList.add(contact);
        phoneBook.groupsMap.put("ini", phoneBook.arrayList);
        Contact actual = phoneBook.searchByNumber(89830002343L);
        assertThat(contact, samePropertyValuesAs(actual));
    }

    @Test
    public void createContactTest() {
        Contact actual = phoneBook.createContact(89830002343L, "Pavel");
        assertThat(contact, samePropertyValuesAs(actual));
    }
}
