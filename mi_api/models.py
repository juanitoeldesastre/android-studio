# models.py
from config import db, ma

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100))
    email = db.Column(db.String(100), unique=True)

    def __init__(self, name, email):
        self.name = name
        self.email = email

class UserSchema(ma.Schema):
    class Meta:
        fields = ("id", "name", "email")

user_schema = UserSchema()
users_schema = UserSchema(many=True)
