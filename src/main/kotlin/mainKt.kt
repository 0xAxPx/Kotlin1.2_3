
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`).useLocale(Locale.US)
    println("Enter user last purchase amount: ")
    val amount = scanner.nextInt()
    println("Is user loyal (Y or N): ")
    val loyalty = scanner.next().trim().toLowerCase().equals("y")
    val amountAfterDiscount = amount - calculateInitialDiscount(amount) - calculateLoyalDiscount(amount, loyalty)
    println("After applying discount... Total sum : $amountAfterDiscount")
}

fun calculateInitialDiscount(amount: Int): Int {
    val initialDiscount: Int
    when (amount) {
        in 0..1_000 -> {
            initialDiscount = 0
            println("\tYou discount 0 rub")
        }
        in 1_001..10_000 -> {
            initialDiscount = 100
            println("\tYou discount 100 rub, and after applying it")
        }
        else -> {
            initialDiscount = (amount * 0.05).toInt()
            println("\tYou discount 5%, and after applying it, discount (in rub) = $initialDiscount")
        }
    }
    return initialDiscount
}

fun calculateLoyalDiscount(amount : Int, loyal : Boolean) : Int {
    val discountLoyal: Int
    if (loyal) {
        discountLoyal = (amount * 0.01).toInt()
        println("\tYou loyal discount 1%, and discount (in rub) = $discountLoyal")
    } else {
        discountLoyal = 0
    }
    return discountLoyal
}