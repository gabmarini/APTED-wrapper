import random
from random import shuffle
from _io import open

fields = ["last_name", "first_name", "email", "work.department", "work.street", "work.room", "work.room.type", "address.street", "address.civic", "address.state"]

first_names = ["luca", "marco", "antonio", "gabriele", "maria", "giada", "gloria"]
last_names = ["rossi", "verdi", "bianchi", "gialli", "neri"]
emails = ["1","2","3","4","5","6","7","8","9"]
work_departments = ["1","2","3","4","5","6","7","8","9"]
work_streets = ["1","2","3","4","5","6","7","8","9"]
work_rooms = ["1","2","3","4","5","6","7","8","9"]
work_rooms_types = ["1","2","3","4","5","6","7","8","9"]
address_streets = ["1","2","3","4","5","6","7","8","9"]
address_civics = ["1","2","3","4","5","6","7","8","9"]
address_states = ["1","2","3","4","5","6","7","8","9"]

separator = "##"
results = []

for i in range(1000):
    for field in fields:
        if field == "last_name":
            results.append(str(i) + separator + field + "\t" + random.choice(last_names))
        elif field == "first_name":
            results.append(str(i) + separator + field + "\t" + random.choice(first_names))
        elif field == "email":
            results.append(str(i) + separator + field + "\t" + random.choice(emails))
        elif field == "work.department":
            results.append(str(i) + separator + separator.join(field.split('.')) + "\t" + random.choice(work_departments))
        elif field == "work.street":
            results.append(str(i) + separator + separator.join(field.split('.')) + "\t" + random.choice(work_streets))
        elif field == "work.room":
            results.append(str(i) + separator + separator.join(field.split('.')) + "\t" + random.choice(work_rooms))
        elif field == "work.room.type":
            results.append(str(i) + separator + separator.join(field.split('.')) + "\t" + random.choice(work_rooms_types))
        elif field == "address.street":
            results.append(str(i) + separator + separator.join(field.split('.')) + "\t" + random.choice(address_streets))
        elif field == "address.civic":
            results.append(str(i) + separator + separator.join(field.split('.')) + "\t" + random.choice(address_civics))
        else:
            results.append(str(i) + separator + separator.join(field.split('.')) + "\t" + random.choice(address_states))
            
shuffle(results)

with open("KVs.txt","w") as file:
    for result in results:
        file.write(result + "\n")