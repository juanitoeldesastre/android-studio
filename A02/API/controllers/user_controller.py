from flask import Blueprint, jsonify, request
from API.models.user import User
from API import db

user_blueprint = Blueprint('user', __name__)

@user_blueprint.route('/users', methods=['GET'])
def get_users():
    users = User.query.all()
    return jsonify([{'id': user.id, 'username': user.username, 'email': user.email} for user in users])

@user_blueprint.route('/users/<int:id>', methods=['GET'])
def get_user(id):
    user = User.query.get_or_404(id)
    return jsonify({'id': user.id, 'username': user.username, 'email': user.email})

@user_blueprint.route('/users', methods=['POST'])
def create_user():
    data = request.get_json()
    user = User(username=data['username'], email=data['email'])
    db.session.add(user)
    db.session.commit()
    return jsonify({'id': user.id, 'username': user.username, 'email': user.email}), 201

@user_blueprint.route('/users/<int:id>', methods=['PUT'])
def update_user(id):
    user = User.query.get_or_404(id)
    data = request.get_json()
    user.username = data['username']
    user.email = data['email']
    db.session.commit()
    return jsonify({'id': user.id, 'username': user.username, 'email': user.email})

@user_blueprint.route('/users/<int:id>', methods=['DELETE'])
def delete_user(id):
    user = User.query.get_or_404(id)
    db.session.delete(user)
    db.session.commit()
    return '', 204