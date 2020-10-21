package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User userFound = null;
        for (User user : users) {
            if (user.getUsername().trim().equals(login)) {
                userFound = user;
            }
        }

        if (userFound == null) {
            throw new UserNotFoundException("User with login \"" + login + "\" is not found");
        }

        return userFound;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User \"" + user.getUsername() + "\" is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Ivan Ivanov", false)
        };

        try {
            User user = findUser(users, "Ivan Ivanov");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e1) {
            e1.printStackTrace();
        } catch (UserNotFoundException e2) {
            e2.printStackTrace();
        }
    }
}
