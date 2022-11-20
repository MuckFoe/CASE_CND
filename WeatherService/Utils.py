import json


def replace_all_mutated_vowels(json_object):
    """
    Replaces all 'Umlaute' or mutated vowels in a json object
    does this by converting to string and then replacing and then back to json object
    :param json_object: json object you want to filter
    :return: filtered json object
    """
    string = repr(json_object)
    string = string.replace(chr(252), 'ue')
    string = string.replace(chr(246), 'oe')
    string = string.replace(chr(228), 'ae')
    string = string.replace(chr(214), 'Oe')
    string = string.replace(chr(220), 'Ue')
    string = string.replace(chr(196), 'Ae')
    string = string.replace('\'', '"')
    return json.loads(string)
