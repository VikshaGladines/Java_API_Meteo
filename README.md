# Prévisions météo

## Requête HTTP

`POST /meteo`

```json
{
    "city": "Paris"
}
```

Pour récupérer les prévisions météo : https://api.openweathermap.org/data/2.5/weather?q=Paris&appid=5dfc2a06c8157403e9107053a73aca92&lang=fr&main.temp=Celsius

## Réponse HTTP

```json
{
    "coucher":"15:53",
    "humidite":70,
    "icon":803,
    "lever":"07:31",
    "temp":8.13,
    "temps":"nuageux"
}
```

Pour l'icône, récupérer l'attribut `id` de l'élément `weather`. Attention les heures de coucher et de lever de soleil sont de timestamp Unix et les températures sont en Kelvin.