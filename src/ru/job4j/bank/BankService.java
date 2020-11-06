package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> listOfAccounts = users.get(user.get());
            if (!listOfAccounts.contains(account)) {
                listOfAccounts.add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = users.keySet().stream().distinct()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst();
        return rsl;

//        Optional<User> rsl = Optional.empty();
//        for (User user : users.keySet()) {
//            if (user.getPassport().equals(passport)) {
//                rsl = Optional.of(user);
//                break;
//            }
//        }
//        return rsl;

    }

    public Account findByRequisite(String passport, String requisite) {
        Account res = null;
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> listOfAccounts = users.get(user.get()).stream().distinct()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .collect(Collectors.toList());
            if (listOfAccounts.size() > 0) {
                res = listOfAccounts.get(0);
            }

//            for (Account account : listOfAccounts) {
//                if (account.getRequisite().equals(requisite)) {
//                    return account;
//                }
//            }
        }
        return res;
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

        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        String passNo = "3211";
        Optional<User> opt = bank.findByPassport(passNo);
        if (opt.isPresent()) {
            System.out.println(opt.get().getUsername());
        } else {
            System.out.println("User with passport " + passNo + " is not found");
        }
    }
}
