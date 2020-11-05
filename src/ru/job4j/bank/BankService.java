package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> listOfAccounts = users.get(user);
            if (!listOfAccounts.contains(account)) {
                listOfAccounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        List<User> res = users.keySet().stream().distinct()
                .filter(e -> e.getPassport().equals(passport))
                .collect(Collectors.toList());
        return res.size() > 0 ? res.get(0) : null;

//        for (User user : users.keySet()) {
//            if (user.getPassport().equals(passport)) {
//                return user;
//            }
//        }
//        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> listOfAccounts = users.get(user);
            List<Account> res = listOfAccounts.stream().distinct()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .collect(Collectors.toList());
            return res.size() > 0 ? res.get(0) : null;

//            for (Account account : listOfAccounts) {
//                if (account.getRequisite().equals(requisite)) {
//                    return account;
//                }
//            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null
                && destAccount != null
                && srcAccount.getBalance() >= amount) {
            double destBalance = destAccount.getBalance();
            destAccount.setBalance(destBalance + amount);
            return true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}
