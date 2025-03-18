# controllers.py
from flask import request, jsonify
from config import db
from models import User, user_schema, users_schema

def get_users():
    users = User.query.all()
    return users_schema.jsonify(users)

def get_user(user_id):
    user = User.query.get(user_id)
    return user_schema.jsonify(user) if user else jsonify({"message": "Usuario no encontrado"}), 404

def create_user():
    name = request.json["name"]
    email = request.json["email"]
    new_user = User(name, email)

    db.session.add(new_user)
    db.session.commit()
    return user_schema.jsonify(new_user)

def update_user(user_id):
    user = User.query.get(user_id)
    if not user:
        return jsonify({"message": "Usuario no encontrado"}), 404

    user.name = request.json.get("name", user.name)
    user.email = request.json.get("email", user.email)

    db.session.commit()
    return user_schema.jsonify(user)

def delete_user(user_id):
    user = User.query.get(user_id)
    if not user:
        return jsonify({"message": "Usuario no encontrado"}), 404

    db.session.delete(user)
    db.session.commit()
    return jsonify({"message": "Usuario eliminado"})
