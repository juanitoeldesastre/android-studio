# routes.py
from config import app
from controllers import get_users, get_user, create_user, update_user, delete_user

app.add_url_rule("/users", "get_users", get_users, methods=["GET"])
app.add_url_rule("/users/<int:user_id>", "get_user", get_user, methods=["GET"])
app.add_url_rule("/users", "create_user", create_user, methods=["POST"])
app.add_url_rule("/users/<int:user_id>", "update_user", update_user, methods=["PUT"])
app.add_url_rule("/users/<int:user_id>", "delete_user", delete_user, methods=["DELETE"])
