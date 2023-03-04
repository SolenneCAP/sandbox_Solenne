package fr.simplon.sandbox.db.dbobjects;


public record User(int id, String login, String firstName, String lastName, Role role){}

