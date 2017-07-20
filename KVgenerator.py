import random
from random import shuffle
from _io import open
from builtins import str
import sys

fields = ["last_name", "first_name", "email", "work.department", "work.street.number", "work.room", "work.room.type", "address.street", "address.civic", "address.state"]

first_names = ["luca", "marco", "antonio", "gabriele", "maria", "giada", "gloria"]
last_names = ["rossi", "verdi", "bianchi", "gialli", "neri"]
emails = ["aaa@aaa.com","bbb@bbb.com","ccc@ccc.com","ddd@ddd.com","eee@eee.com","fff@fff.com","ggg@ggg.com","hhh@hhh.com","iii@iii.com"]
work_departments = ["electronics","miniaturization","ceramic","IT","artificial intelligence","don't know","a good dep","another good dep","great department"]
work_streets = ["21st","second","third avenue","fourth rue","good street","great avenue","simple row","narrow street","cubic sq."]
work_rooms = ["243","123b","second45","893re","909","320w","132w","345f","good room"]
work_rooms_types = ["great","neat","wonderfull","not so good","meh...","no no NO","yes yes YES","great type","don't know"]
address_streets = ["wonderwall rue","simplicistic ave","star rue","sea avenue","fade to black sq.","yellow street","black plaza","don't know avenuwe","no more ideas sq."]
address_civics = ["1","2","3","4","5","6","7","8","9"]
address_states = ["USA","RU","IT","RM","MI","GR","SP","PO","GB"]

separator = "##"
results = []

table = "people" + separator
for i in range(10000):
    for field in fields:
        if field == "last_name":
            results.append(table + str(i) + separator + field + "\t" + random.choice(last_names))
        elif field == "first_name":
            results.append(table + str(i) + separator + field + "\t" + random.choice(first_names))
        elif field == "email":
            results.append(table + str(i) + separator + field + "\t" + random.choice(emails))
        elif field == "work.department":
            results.append(table + str(i) + separator + separator.join(field.split('.')) + "\t" + random.choice(work_departments))
        elif field == "work.street.number":
            results.append(table + str(i) + separator + separator.join(field.split('.')) + "\t" + random.choice(work_streets))
        elif field == "work.room":
            results.append(table + str(i) + separator + separator.join(field.split('.')) + "\t" + random.choice(work_rooms))
        elif field == "work.room.type":
            results.append(table + str(i) + separator + separator.join(field.split('.')) + "\t" + random.choice(work_rooms_types))
        elif field == "address.street":
            results.append(table + str(i) + separator + separator.join(field.split('.') + [str(i)]) + "\t" + random.choice(address_streets))
        elif field == "address.civic":
            results.append(table + str(i) + separator + separator.join(field.split('.') + [str(i)]) + "\t" + random.choice(address_civics))
        else:
            results.append(table + str(i) + separator + separator.join(field.split('.') + [str(i)]) + "\t" + random.choice(address_states))
        print i
shuffle(results)

with open("kvs.txt","w") as file:
    for result in results:
        file.write(result + "\n")