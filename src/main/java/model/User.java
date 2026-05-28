package model;

import Enums.Type;
import java.util.ArrayList;

public class User {

    private static User loggedInUser;
    private static final ArrayList<User> allUsers = new ArrayList<>();
    private String username;
    private String password;
    private String nickname;
    private String email;
    private int numberOfCardInDeck;
    private int numberOfSpecialCardInDeck;
    private int highestScore;
    private int wins;
    private int looses;
    private int draws;
    private int rank;
    private final ArrayList<Card> deck = new ArrayList<>();
    private int matches;
    private String securityQuestion;
    private String securityAnswer;
    private final ArrayList<User> friendRequest = new ArrayList<>();

    public User(String username, String password, String nickname, String email, String securityQuestion, String securityAnswer) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        allUsers.add(this);
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        User.loggedInUser = loggedInUser;
    }

    public static User getUserByName(String username) {

        for (User user : allUsers) {
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoose() {
        return looses;
    }

    public void setLoose(int loose) {
        this.looses = loose;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void addCardToDeck(PlayableCard card) {
        deck.add(card);
        numberOfCardInDeck++;
        if (card.getType() == Type.SPELL || card.getType() == Type.WHETHER) numberOfSpecialCardInDeck++;
    }

    public void removeCardFromDeck(PlayableCard card) {
        deck.remove(card);
        numberOfCardInDeck--;
        if (card.getType() == Type.SPELL || card.getType() == Type.WHETHER) numberOfSpecialCardInDeck--;
    }

    public void removeAllCardFromDeck() {
        deck.clear();
        numberOfCardInDeck = 0;
        numberOfSpecialCardInDeck = 0;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public boolean isCardInDeck(Card card) {
        for (Card currentCard : deck) {
            if (currentCard == card) return true;
        }
        return false;
    }

    public int getNumberOfCardInDeck() {
        return numberOfCardInDeck;
    }

    public int getNumberOfSpecialCardInDeck() {
        return numberOfSpecialCardInDeck;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public ArrayList<User> getFriendRequest() {
        return friendRequest;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

}
