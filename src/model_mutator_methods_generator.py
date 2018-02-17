
dict = {'Integer': 'int', 'String': 'String', 'Object': 'undefined', 'Float': 'float', 'Boolean': 'bool'}

def simple_getter(words):
    field_type = words[1]
    words[2] = words[2].replace(';', ' ')
    parametr_type = ''
    for key, value in dict.items():
        if key in field_type:
            if key is 'Object':
                parametr_type = field_type.split('<')[1].replace('>', ' ')
            else:
                parametr_type = value
            break
    return "public " + str(parametr_type) + " get" + str(words[2][0].upper() + words[2][1:]).strip() +"(){\n return " + str(words[2]).strip() + ".get();\n}\n"

def property_getter(words):
    return_type = words[1]
    words[2] = words[2].replace(';', ' ')
    return "public " + str(return_type) + " get" + str(words[2][0].upper() + words[2][1:]).strip() +"Property(){\n return " + str(words[2]).strip() + ";\n}\n"
    
def simple_setter(words):
    field_type = words[1]
    words[2] = words[2].replace(';', ' ')
    parametr_type = ''
    for key, value in dict.items():
        if key in field_type:
            if key is 'Object':
                parametr_type = field_type.split('<')[1].replace('>', ' ')
            else:
                parametr_type = value
            break
    return "public void set" + str(words[2][0].upper() + words[2][1:]).strip() + "(" + parametr_type + " " + words[2].strip() +")" +   " {\n this." + str(words[2]).strip() + ".set(" + words[2].strip() + ");\n}\n"


lines = []        
print('example: private IntegerProperty id')
while True:
  line = input('Enter field (empty str to exit): ')
  if not line:
    break
  lines.append(line)

words = []

for line in lines:
  words = line.split(' ')
  print(simple_getter(words))
  print(property_getter(words))
  print(simple_setter(words))
  


