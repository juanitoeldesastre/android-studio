from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate
from API.config import Config

app = Flask(__name__)
app.config.from_object(Config)

db = SQLAlchemy(app)
migrate = Migrate(app, db)

from API.models.user import User  
from API.controllers.user_controller import user_blueprint

app.register_blueprint(user_blueprint)