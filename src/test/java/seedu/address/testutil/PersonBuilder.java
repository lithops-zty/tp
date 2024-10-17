package seedu.address.testutil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.ModuleCode;
import seedu.address.model.person.ModuleRoleMap;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.RoleType;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    public static final ModuleCode DEFAULT_MODULE_CODE = new ModuleCode("CS1101S");
    public static final RoleType DEFAULT_ROLE_TYPE = RoleType.STUDENT;

    private Name name;
    private Phone phone;
    private Email email;
    private Optional<Address> address;
    private Set<Tag> tags;
    private ModuleRoleMap moduleRoleMap;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = Optional.of(new Address(DEFAULT_ADDRESS));
        tags = new HashSet<>();

        HashMap<ModuleCode, RoleType> hashMap = new HashMap<>();
        hashMap.put(DEFAULT_MODULE_CODE, DEFAULT_ROLE_TYPE);
        moduleRoleMap = new ModuleRoleMap(hashMap);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        tags = new HashSet<>(personToCopy.getTags());
        moduleRoleMap = personToCopy.getModuleRoleMap();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Use {@code DEFAULT_MODULE_CODE} and {@code DEFAULT_ROLE_TYPE} to construct a default {@code ModuleRoleMap}
     * for the {@code Person} that we are building.
     */
    public PersonBuilder withDefaultModuleRoleMap() {
        HashMap<ModuleCode, RoleType> moduleRoleMap = new HashMap<>();
        moduleRoleMap.put(DEFAULT_MODULE_CODE, DEFAULT_ROLE_TYPE);
        this.moduleRoleMap = new ModuleRoleMap(moduleRoleMap);
        return this;
    }

    /**
     * Parses the {@code ModuleRoleMap} into a {@code ModuleRoleMap} and set it to the {@code Person}
     * that we are building.
     */
    public PersonBuilder withModuleRoleMap(ModuleCode moduleCode, RoleType roleType) {
        HashMap<ModuleCode, RoleType> moduleRoleMap = new HashMap<>();
        moduleRoleMap.put(moduleCode, roleType);
        this.moduleRoleMap = new ModuleRoleMap(moduleRoleMap);
        return this;
    }

    /**
     * Parses the {@code ModuleRoleMap} into a {@code ModuleRoleMap} and set it to the {@code Person}
     * that we are building.
     */
    public PersonBuilder withModuleRoleMap(ModuleCode[] moduleCodes, RoleType[] roleTypes) {
        this.moduleRoleMap = new ModuleRoleMap(moduleCodes, roleTypes);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = Optional.of(new Address(address));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building to be null.
     */
    public PersonBuilder withEmptyAddress() {
        this.address = Optional.empty();
        return this;
    }


    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    //remember to check here

    /**
     * Builds the {@code Person} that we are testing.
     */
    public Person build() {
        return new Person(name, phone, email, address, tags, moduleRoleMap);
    }

    /**
     * Builds the {@code Person} that we are testing without address.
     */
    public Person buildEmptyAddressPerson() {
        return new Person(name, phone, email, Optional.empty(), tags, moduleRoleMap);
    }

}
